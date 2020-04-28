package Stack.mid;

//以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
//
//        在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
//        请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/simplify-path
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.LinkedList;
import java.util.Stack;

public class P71 {
    public static String simplifyPath(String path) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.addFirst('/');
        for(int i=0; i<path.length(); i++){
            char c = path.charAt(i);
            char peek = stack.peekLast();
            if(c == '/'){
                if (peek == '/'){
                    continue;
                }
                if (peek == '.'){
                    stack.removeLast();
                    continue;
                }
            }
            if (c == '.'){
                if (peek == '.'){
                    stack.removeLast();
                    if(stack.size() > 1){
                        stack.removeLast();
                        while (stack.peekLast() != '/'){
                            stack.removeLast();
                        }
                    }
                    continue;
                }
            }
            stack.addLast(c);

        }
        if (stack.peekLast() == '/' && stack.size()>1)
            stack.removeLast();
        if(stack.peekLast() == '.')
            stack.removeLast();

        StringBuilder sb = new StringBuilder();
        while (stack.size()>0){
            sb.append(stack.remove());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String path = new String("/././././../.");
        String s = simplifyPath(path);
        System.out.println(s);
    }
}
