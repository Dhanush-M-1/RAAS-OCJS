for _ in range(int(input())):
    n=int(input())
    a=[int(o) for o in input().split()]
    a=[-1]+a
    a1=a[:]
    n+=1
    flag=-1
    for i in range(1,n):
        # a[i]=min(a[i-1]-1,a[i])
        a1[i]=min(a1[i-1]+1,a1[i])
        if a1[i]<=a1[i-1]:
            a1[i-1]=a[i-1]
            flag=i
            break
    if flag!=-1:
        for i in range(flag,n):
            a1[i]=min(a1[i-1]-1,a1[i])
    
    # print(a1)
    if flag==-1:
        print("Yes")
    else:
        flag1=0
        for i in range(flag,n):
            if a1[i]<0:
                flag1=1
        if flag1==0:
            print("Yes")
        else:
            print("No")
            
            