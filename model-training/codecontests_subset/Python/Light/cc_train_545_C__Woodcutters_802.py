n=int(input())
a=[]
b=[]
count=2
for i in range(n):
    x,y=map(int,input().split())
    a.append(x)
    b.append(y)
for i in range(n):
    if i>0 and i<n-1:
        if a[i]-a[i-1]>b[i]:
            count+=1 
        elif a[i+1]-a[i]>b[i]:
            a[i]+=b[i]
            count+=1 
if n==1:
    print(1)
else:
    print(count)
            