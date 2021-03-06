apply from:"../common_component_build.gradle"

android {
  resourcePrefix "module_name_" //给 Module 内的资源名增加前缀, 避免资源名冲突
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    api project(":ComRes")//因为 CommonRes 依赖了 CommonSDK, 所以如果业务模块需要公共 UI 组件就依赖 CommonRes, 如果不需要就只依赖 
    api project(":ComService")

}
