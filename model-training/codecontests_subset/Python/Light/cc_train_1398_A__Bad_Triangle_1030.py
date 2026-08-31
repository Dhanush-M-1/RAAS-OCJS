t=int(input())
while(t):
    n=int(input())
    a=list(map(int,input().split()))
    if n>2:
        flag=0
        for i in range(len(a)-2):
            if(a[i]+a[i+1]>a[n-1]):
                continue
            else:
                flag=1
                print(i+1,end=" ")
                print(i+2,end=" ")
                print(n)
                break
        if(flag!=1):
            print("-1")
    t=t-1