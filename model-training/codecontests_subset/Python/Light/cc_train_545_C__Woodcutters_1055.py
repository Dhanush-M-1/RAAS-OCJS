n=int(input())
a=[]
for j in range(n):
    a.append(list(map(int,input().split())))
if n<=2:
    print(n)
else:
    p=a[0][0]
    c=2
    for j in range(1,n-1):
        if a[j][0]-a[j][1]>p:
            p=a[j][0]
            c=c+1
        elif a[j][0]+a[j][1]<a[j+1][0]:
            p=a[j][0]+a[j][1]
            c=c+1
        else:
            p=a[j][0]
    print(c)