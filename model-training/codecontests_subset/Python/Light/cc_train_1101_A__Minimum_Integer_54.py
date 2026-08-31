q=int(input())

for _ in range(0,q):
    l,r,n=map(int,input().split())
    if(n<l):
        div=l//n
        rem=l%n;
        if(rem==0):
            ans=l-n*(div-1)
        else:
            ans=l-rem
            rem=ans%n
            div=ans//n
            l=ans
            if(rem==0):
                ans=l-n*(div-1)


    elif(n>r):
        ans=n;
    elif(n==r):
        ans=2*n

    elif(n<r):
        rem=r%n
        if(rem==0):
            ans=r+n
        else:
            div=r//n
            ans=(div+1)*n
    print(ans)        

