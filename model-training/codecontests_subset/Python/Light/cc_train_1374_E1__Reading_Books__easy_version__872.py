# t=int(input())
# for j in range(t):
n,k = map(int, input().split())
t=[]
a=[]
b=[]
for i in range(n):
    t1,a1,b1 = map(int, input().split())
    if(a1==1 and b1==1):
        t.append(t1)
    elif(a1==1):
        a.append(t1)
    elif(b1==1):
        b.append(t1)
a.sort()
b.sort()
k1=min(len(a),len(b))
for i in range(k1):
    t.append(a[i]+b[i])
ans=0
t.sort()
if(len(t)<k):
    print("-1")
else:
    print(sum(t[:k]))
    