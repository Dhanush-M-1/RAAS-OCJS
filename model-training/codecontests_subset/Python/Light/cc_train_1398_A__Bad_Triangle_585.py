for _ in range(int(input())):
    N=int(input())
    a=list(map(int,input().split()))
    x=a[0]+a[1]
    flag=0
    for i in range(2,len(a)):
        if(a[i]>=x):
            print(1,2,i+1)
            flag=1
            break
    if(flag==0):
        print(-1)
                