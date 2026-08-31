t=int(input())
for i in range (0,t):
    n=int(input())
    p=[0]*n
    c=[0]*n
    for k in range (0,n):
        p[k],c[k]=map(int,input().split())
    if n==1:
        if p[0]>=c[0]:
            print('YES')
        else:
            print('NO')
    else:
        s=0
        for j in range (0,n-1):
            if p[j]<c[j] or p[j+1]-p[j]<c[j+1]-c[j] or p[j+1]<p[j] or c[j+1]<c[j]:
                s=1
                break
        if p[n-1]<c[n-1]:
            s=1
        if s==1:
            print('NO')
        else:
            print('YES')




