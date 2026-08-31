for _ in range(int(input())):
    a,b=map(int,input().split())
    x=list(map(int,input().split()))
    y=list(map(int,input().split()))
    if x == y:
        print('YES')
        print(1,x[0])
    else:
        su=0
        flag=0
        for i in range(0,len(x)):
            for j in range(0,len(y)):
                if x[i]==y[j]:
                    flag=1
                    su=x[i]
                    break
        if(flag==1):
            print('YES')
            print(1,su)
        else:
            print('NO')