n,k=map(int, input().split())
ab=[]
a=[]
b=[]

for i in range(n):
    t,x,y=map(int, input().split())
    if x==1 and y==1:
        ab.append(t)
    elif x==1 and y!=1:
        a.append(t)
    elif x==0 and y==1:
        b.append(t)
a.sort()
b.sort()
cnt=min(len(a),len(b))
for i in range(cnt):
    ab.append(a[i]+b[i])
if len(ab)<k:
    print(-1)
else:
    ab=sorted(ab)
    print(sum(ab[: k]))
