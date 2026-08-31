t=int(input())
while(t>0):
    n=int(input())
    a=list(map(int,input().split()))
    s=a[0]+a[1]
    ans=-1
    for i in range(2,n):
        if(a[i]>=s):
            ans=i
        else:
            continue


    if(ans!=-1):
        print("1 2 "+str(ans+1))
    else:
        print(ans)

    t-=1




