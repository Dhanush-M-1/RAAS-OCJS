for _ in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    ans=False
    if n==min(n,m):
        for i in range(n):
            if a[i] in b:
                ans=True
                break
        if ans:
            print('YES')
            print(1, a[i])
        else:
            print('NO')
    elif m==min(n,m):
        for i in range(m):
            if b[i] in a:
                ans=True
                break
        if ans:
            print('YES')
            print(1,b[i])
        else:
            print('NO')