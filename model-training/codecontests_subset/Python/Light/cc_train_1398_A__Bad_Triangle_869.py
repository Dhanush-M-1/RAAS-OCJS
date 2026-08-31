for i in range(int(input())):
    a=int(input())
    b=list(input().split())
    if int(b[0])+int(b[1])<=int(b[-1]):
        print("1","2",a)
    else:
        print("-1")