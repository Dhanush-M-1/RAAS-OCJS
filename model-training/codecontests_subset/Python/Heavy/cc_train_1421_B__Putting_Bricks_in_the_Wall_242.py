t=int(input())
for _ in range(t):
    n=int(input())
    up=[-1,-1]
    down=[-1,-1]
    for i in range(n):
        s=input()
        if i==0:
            up[0]=s[1]
        elif i==1:
            up[1]=s[0]
        if i==n-2:
            down[0]=s[-1]
        elif i==n-1:
            down[1]=s[-2]

    if up[0]==up[1] and down[0]==down[1]:
        if up[0]==down[0]:
            print(2)
            print(1,2)
            print(2,1)
        else:
            print(0)
    elif up[0]==up[1]:
        if down[0]==up[0]:
            print(1)
            print(n-1,n)
        else:
            print(1)
            print(n,n-1)
    elif down[0]==down[1]:
        if down[0]==up[0]:
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    else:
        print(2)
        print(1,2)
        if up[0]!=down[0]:
            print(n-1,n)
        else:
            print(n,n-1)