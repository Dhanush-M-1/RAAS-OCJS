n=int(input())
x=[0]*n
h=[0]*n
for i in range(n):
    x[i],h[i]=map(int,input().split(" "))
space=[0]*(n-1)
count=2
for i in range(n-1):
    space[i]=x[i+1]-x[i]
for i in range(1,n-1):
    if h[i]<space[i-1]:
        count+=1
    elif h[i]<space[i]:
        count+=1
        space[i]-=h[i]
if n==1:
    count=1
print(count)