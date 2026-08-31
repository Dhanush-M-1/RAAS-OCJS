n,m=map(int,input().split())
l=[i+1 for i in range(m)]
for i in range(n):
    x=[int(i) for i in input().split()]
    for i in range(len(x)-1):
        if x[i+1] in l[:]:
            l.remove(x[i+1])
if len(l)==0:
    print("YES")   
else:
    print("NO")         