t=int(input())
r=[]
for i in range(t):
    b=[]
    d=[]
    n=int(input())
    for j in range(n):
        a=list(map(int, input().split()))
        b.append(a[0])
        d.append(a[1])
    if b[0]<d[0]:
        r.append("NO")
    else:
        p=[x - b[i - 1] for i, x in enumerate(b) if i > 0]
        c=[x - d[i - 1] for i, x in enumerate(d) if i > 0]
        s1=sum(1 for number in p if number < 0)
        s2=sum(1 for number in c if number < 0)
        if s1!=0 or s2!=0:
            r.append("NO")
        else:
            q=0
            for j in range(n-1):
                if p[j]!=c[j]:
                    if p[j]<c[j]:
                        q=q+1
            if q!=0:
                r.append("NO")
            else:
                r.append("YES")
for i in range(len(r)):
    print(r[i])