t=int(input())
for _ in range(t):
    n=int(input())
    l,p=[],[]
    for i in range(n):
        a,b=map(int,input().split())
        l.append(a)
        p.append(b)
    if n==1 and l[0]<p[0]:
        print("NO")
    elif n==1 and l[0]>=p[0]:
        print("YES")
    else:
        for i in range(1,n):
            f=0
            if l[0]<p[0]:
                f=1
                break
            if max(l[0:i])>l[i] or max(p[0:i])>p[i] or l[i]<p[i] or (l[i]-l[i-1])<(p[i]-p[i-1]):
                f=1
                break
        if f==1:
            print("NO")
        else:
            print("YES")