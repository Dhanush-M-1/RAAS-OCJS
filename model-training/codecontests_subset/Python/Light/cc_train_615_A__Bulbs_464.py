a,b=map(int,input().split())
y=[]
k=0
for i in range(0,a):
    x=list(map(int,input().split()))
    y.extend(x[1:])
for i in range(1,b+1):
    if(y.count(i)<1):
        k=-1
        print("NO")
        break
if(k==0):
    print("YES")
    