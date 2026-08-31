n,k=map(int,input().split())
a=list(map(int,input().split()))
a.sort()
x=[]
for i in range(0,n):
    if k%a[i]==0:
        x.append(k//a[i])
print(min(x))
    