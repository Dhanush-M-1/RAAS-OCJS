n=int(input())
a=[]
for i in range(n):
    a.append([int(x) for x in input().split()])
if n==1:
    print(1)
else:
    num=2
    k=a[0][0]
    for i in range(1,n-1):
        if a[i][1]+1<=a[i][0]-k:
            num+=1
            k=a[i][0]
        elif a[i][1]+1<=a[i+1][0]-a[i][0]:
            num+=1
            k=a[i][0]+a[i][1]
        else:
            k=a[i][0]
    print(num)
