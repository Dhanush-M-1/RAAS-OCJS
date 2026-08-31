n=int(input())
a=[[int(i)for i in input().split()]for k in range(n)]
last=a[0][0]
x=2
for i in range(1,n-1):
    if a[i][0]-a[i][1]>last:
        last=a[i][0]
        x+=1
    elif a[i+1][0]-a[i][0]>a[i][1]:
        last=a[i][0]+a[i][1]
        x+=1
    else:
        last=a[i][0]
if n==1:
    print(1)
else:
    print(x)
        
