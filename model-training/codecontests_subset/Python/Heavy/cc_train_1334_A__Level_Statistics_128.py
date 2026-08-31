t=int(input())
for test in range(t):
    a=[]
    n=int(input())
    for i in range(n):
        temp=list(map(int,input().split()))
        a.append(temp)
    flag=0
    for i in range(0,len(a)):
        if a[i][1]>a[i][0]:
            flag=1
            break
    for i in range(1,len(a)):
        if a[i][1]<a[i-1][1] or a[i][0]<a[i-1][0]:
            flag=1
            break
    if flag==1:
        print("NO")
    else:
        flag1=0

        for i in range(1,len(a)):
            if a[i][0]-a[i-1][0]<a[i][1]-a[i-1][1]:
                flag1=1
                break
        if flag1==1:
            print("NO")
        else:
            print("YES")