t=int(input())
for i in range(t):
    n=int(input())
    a=[]
    flag=0
    for j in range(n):
        p,c=list(map(int,input().split()))
        a.append([p,c])
    if(a[0][0]<a[0][1]):
        flag=1
    for j in range(1,n):
        if(a[j][0]<a[j][1]):
            flag=1
            break
        if(a[j][0]-a[j-1][0]<a[j][1]-a[j-1][1]):
            flag=1
            break
        if(a[j][0]<a[j-1][0] or a[j][1]<a[j-1][1]):
            flag=1
            break
    if(flag==1):
        print("NO")
    else:
        print("YES")