for _ in range(int(input())):
    n,m=map(int,input().split())
    l=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    f=False
    if(n>m):
        for i in l:
            if(i in l1):
                f=True
                print('YES')
                print(1,i)
                break
        if(f):
            continue
        else:
            print("NO")
    else:
        for i in l1:
            if(i in l):
                f= True
                print('YES')
                print(1,i)
                break
        if(f):
            continue
        else:
            print('NO')