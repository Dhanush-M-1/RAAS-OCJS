t=int(input())
for j in range(t):
    n=int(input())
    p=[]
    c=[]
    d=0
    for i in range(n):
        l=list(map(int,input().split()))
        p.append(l[0])
        c.append(l[1])
    if(n>1):
        for i in range(1,n):
            if(p[i]>=c[i] and p[i]>=p[i-1] and c[i]>=c[i-1] and p[i]-p[i-1]>=c[i]-c[i-1]):
                d+=1
        if(d==n-1 and p[0]>=c[0]):
            print("YES")
        else:
            print("NO")
    else:
        if(p[0]>=c[0]):
            print("YES")
        else:
            print("NO")
    