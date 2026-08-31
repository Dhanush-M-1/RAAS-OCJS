q = int(input())
a=[]
for i in range(q):
    l,r,d = map(int, input().split())
    if d<l or d>r:
        a.append(d)
    else:
        r+=1
        if r%d==0:
            a.append(r)
        else:
            n = r + (d-(r%d))
            a.append(n)
for i in a:
    print(i)

