t = int(input())
for i in range(t):
    n = int(input())
    p=[]
    c=[]
    for j in range(n):
        a,b=map(int,input().split())
        p.append(a)
        c.append(b)
    if c[0]>p[0]:
        print("NO")
        continue
    elif n==1:
        print("YES")
    for j in range(1,n):
        if p[j]<p[j-1] or c[j]<c[j-1]:
            print("NO")
            break
        if c[j]>p[j]:
            print("NO")
            break
        if c[j]-c[j-1]>p[j]-p[j-1]:
            print("NO")
            break
        if j==n-1:
            print("YES")