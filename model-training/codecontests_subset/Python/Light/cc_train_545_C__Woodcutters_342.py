n=int(input())
a=[]
for i in range(n):
    x,h=map(int,input().split())
    a.append((x,h))
x=1
b=a[0][0]
for i in range(1,n-1):
    k=a[i]
    s=a[i+1]
    if k[0]-k[1]>b:
        x+=1
        b=k[0]
        continue
    if k[0]+k[1]<s[0]:
        x+=1
        b=k[0]+k[1]
        continue
    b=k[0]
if n==1:
    print(1)
else:
    print(x+1)
