n=int(input())
a=[]
b=[]
c=1
for i in range(n):
    x,y=map(int,input().split())
    a.append(x)
    b.append(y)
if n==1 or n==2:print(n),exit(0)
for i in range(1,n-1):
    if a[i]-a[i-1]>b[i]:c+=1
    elif a[i]+b[i]<a[i+1]:
        c+=1
        a[i]+=b[i]
print(c+1)