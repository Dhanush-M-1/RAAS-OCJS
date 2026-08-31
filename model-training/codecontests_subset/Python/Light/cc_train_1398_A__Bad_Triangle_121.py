t=int(input())
for _ in range(t):
    l=int(input())
    flag=0
    a=list(map(int,input().split(" ")))
    k=a[-1]-a[0]
    for i in range(1,l-1):
        if(a[i]<=k):
            print(1,i+1,l,end=" ")
            flag=1
            print()
            break
    if(flag==0):
        print("-1")