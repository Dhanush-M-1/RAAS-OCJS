def get_arry():
    return list(map(int,input().split()))
def get_int():
    return int(input())
def get_input():
    return input()
def areParanthesisBalanced(expr) :
    stack = []

    for char in expr:
        if char in ["(", "{", "["]:

            stack.append(char)
        else:

            if not stack:
                return False
            current_char = stack.pop()
            if current_char == '(':
                if char != ")":
                    return False
            if current_char == '{':
                if char != "}":
                    return False
            if current_char == '[':
                if char != "]":
                    return False

    # Check Empty Stack
    if stack:
        return False
    return True

def main():
    for _ in range(int(input())):
        n=get_int()
        cnt=0
        flag=0
        if n==1:
            print(0)
        else:
            while n!=1:
                if n%6==0:
                    n=n//6
                else:
                    if (n*2)%6!=0:
                        print(-1)
                        flag=1
                        break
                    else:
                        n=n*2

                cnt+=1
            if flag==0 and cnt!=0:
                print(cnt)
            elif flag==0 and cnt==0:
                print(-1)


if __name__ == '__main__':
    main()
