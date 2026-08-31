t=int(input())
for i in range(t):
    n=int(input())
    p=[]
    c=[]
    for j in range(n):
        p1,c1=map(int,input().split())
        p.append(p1)
        c.append(c1)
    if(p[0]>=c[0]):
        e=1
        for k in range(1,n):
            if(p[k]<p[k-1] or c[k]<c[k-1]):
                e=0
                print("NO")
                break
            elif(c[k]-c[k-1]>p[k]-p[k-1]):
                e=0
                print("NO")
                break
        if(e==1):
            print("YES")
    else:
        print("NO")