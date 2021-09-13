package tal.com.d_stack.node.constants;

// 跳转类型
public class DNodeActionType {

    // push跳转android
    public static final String DNodeActionTypePush = "push";
    
    // 打开新页面的同时，关闭老页面
    public static final String DNodeActionTypePushAndPop = "pushAndPop";

    // present跳转(ios独有)
    public static final String DNodeActionTypePresent = "present";

    // pop返回android
    public static final String DNodeActionTypePop = "pop";

    // popTo 返回
    public static final String DNodeActionTypePopTo = "popTo";

    // PopToRoot
    public static final String DNodeActionTypePopToRoot = "popToRoot";

    // PopSkip
    public static final String DNodeActionTypePopSkip = "popSkip";

    // 手势
    public static final String DNodeActionTypeGesture = "gesture";

    // Dissmiss返回(ios独有)
    public static final String DNodeActionTypeDissmiss = "dissmiss";

    //replace
    public static final String DNodeActionTypeReplace = "replace";

    //pushAndRemoveUntil
    public static final String DNodeActionPushAndRemoveUntil = "pushAndRemoveUntil";
}
