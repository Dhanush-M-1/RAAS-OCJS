t=int(input())
for _ in range(t):
    n=int(input())
    a=[]
    for i in range(n):
        a.append(list(map(int,input().split())))
    e=0
    if a[0][0]<a[0][1]:
        e=1
    for i in range(1,n):
        if a[i][0]<a[i][1]:
            e=1
            break
        if a[i][0]-a[i-1][0]<a[i][1]-a[i-1][1]:
            e=1
            break
        if a[i][0]<a[i-1][0] or a[i][1]<a[i-1][1]:
            e=1
            break
    if e==1:
        print("NO")
    else:
        print("YES")
        
