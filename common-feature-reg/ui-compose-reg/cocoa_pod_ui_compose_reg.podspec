Pod::Spec.new do |spec|
    spec.name                     = 'cocoa_pod_ui_compose_reg'
    spec.version                  = '1.0'
    spec.homepage                 = ''
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = ''
    spec.vendored_frameworks      = 'build/cocoapods/framework/ui_compose_reg.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '15.0'
                
                
    if !Dir.exist?('build/cocoapods/framework/ui_compose_reg.framework') || Dir.empty?('build/cocoapods/framework/ui_compose_reg.framework')
        raise "

        Kotlin framework 'ui_compose_reg' doesn't exist yet, so a proper Xcode project can't be generated.
        'pod install' should be executed after running ':generateDummyFramework' Gradle task:

            ./gradlew :common-feature-reg:ui-compose-reg:generateDummyFramework

        Alternatively, proper pod installation is performed during Gradle sync in the IDE (if Podfile location is set)"
    end
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':common-feature-reg:ui-compose-reg',
        'PRODUCT_MODULE_NAME' => 'ui_compose_reg',
    }
                
    spec.script_phases = [
        {
            :name => 'Build cocoa_pod_ui_compose_reg',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.resources = ['build/compose/cocoapods/compose-resources']
end