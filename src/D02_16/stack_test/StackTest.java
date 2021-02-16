package D02_16.stack_test;

import D02_16.array_stack.MyStack;

public class StackTest {
    private MyStack stack = new MyStack();

    public String reverseString(String str) throws Exception {
        String result = "";
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (int i = 0; i < str.length(); i++) {
            result += stack.pop();
        }
        return result;
    }

    public void decToBinary(int data) throws Exception {
        System.out.println("10진수 : " + data);
        while (data != 0) {
            int bin = data % 2;
            stack.push(bin);
            data /= 2;
        }

        System.out.print("2진수 : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    // 중위 -> 후위 표기법
    /*
        1. 스택 생성
        2. 순환(전달된 문자열의 끝까지)
            2.1 "(" 무시
            2.2 피연산자라면("0-9")
                출력
            2.3 연산자라면(+,-,*,/)
                스택에 push
            2.4 ")"
                스택에서 pop
            한 문자를 이동해가면서
     */
    public void postFix(String str) throws Exception {
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                System.out.print(c + " ");
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    // 중위 -> 후위 표기법 변환 후 반환처리
    public String postFix1(String str) throws Exception {
        String result = "";
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                result += c + " ";
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                result += stack.pop() + " ";
            }
        }
        return result;
    }

    // 중위 -> 후위 표기법 변환 후 반환처리 (두자리수 이상도 가능하게)
    /*
        피연산자가 두자리수 이상일 경우 획득할 수 있는 알고리즘
        1. if(피연산자라면)
            do {
                // 추가 피연산자 체크해 있으면 추가
                // 문자의 이동처리가 필요
            } while(피연산자라면)
     */
    public String postFix2(String str) throws Exception {
        String result = "";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= '0' && c <= '9') {
                do {
                    result += arr[i];
                    i++;
                } while (arr[i] >= '0' && arr[i] <= '9');
                result += " ";
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                result += stack.pop() + " ";
            }
        }
        return result;
    }


    // foreach문 사용방법(do_while문 사용X)
    public String postfix2_1(String str) throws Exception {  //123 + 1
        String result = "";        //<-------------------------

        char[] temp = str.toCharArray();
        for (char t : temp) {
            if (t >= '0' && t <= '9') //피연산자
                result += t;//System.out.print(t + " "); //<-----------------1)
            else if (t == '+' || t == '-' || t == '*' || t == '/') {
                result += " ";
                stack.push(t);
            } else if (t == ')') {
                result += " "; //<--------------------------------2)
                char popchar = (char) stack.pop();
                result += popchar + " ";//System.out.print(popchar + " ");
            }
        }
        //스택에 남은 마지막 연산자를 POP ---------------------------------3)
        char popchar = (char) stack.pop();
        result += popchar + " ";//System.out.print(popchar + " ");

        return result;
    }

    // 후위 표기법에 대한 연산 수행
    /*
        1. 스택 생성
        2. 반복(문자열 끝까지)
            2.1 피연산자라면
                스택에 push
            2.2 연산자라면
                스택에서 피연산자 2개 pop
                연산자를 이용해 결과값 생성
                결과를 스택에 push
     */
    public int postFix_cal(String str) throws Exception {
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
                int num1 = (int) stack.pop();
                int num2 = (int) stack.pop();
                if (arr[i].equals("+")) {
                    stack.push(num2 + num1);
                    continue;
                } else if (arr[i].equals("-")) {
                    stack.push(num2 - num1);
                    continue;
                } else if (arr[i].equals("*")) {
                    stack.push(num2 * num1);
                    continue;
                } else if (arr[i].equals("/")) {
                    try {
                        stack.push(num2 / num1);
                    } catch (ArithmeticException e) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        return -1;
                    }
                    continue;
                }
            }
            stack.push(Integer.parseInt(arr[i]));
        }
        return (int) stack.pop();
    }

    /*
    public static int postfix_cal(String str) {
		char[] arr 		= str.toCharArray();
		MyStack stack 	= new MyStack(arr.length);

		for(char a : arr) {
			if (a == '*' || a == '-' || a=='/'||a=='+') {
				int result = 0;
				int number1 = (int)stack.Pop();
				int number2 = (int)stack.Pop();
				switch(a){
					case '*' :  result = number2 * number1;	break;
					case '/' :	result = number2 / number1;	break;
					case '-' :  result = number2 - number1; break;
					case '+' :  result = number2 + number1;	break;
				}
				stack.Push(result);
			}
			else if( a >= '0' && a <= '9') {
				stack.Push((a-'0'));  //문자를 숫자로 변환!
			}
		}
		return (int)stack.Pop();
	}

     */
}


