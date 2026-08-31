for _ in range(int(input())):
    n=int(input())
    if(n==1):
        print(0)
    elif(n%3!=0):
        print(-1)
    else:
        count=0
        k=n
        ans=0
        while(k%3==0):
            k=k//3
            count+=1
        ans+=count*2
        if(k==1):
            print(ans)
        else:
            cc=0
            while(k%2==0):
                k=k//2
                cc+=1
            if(cc>count or k!=1):
                print(-1)
            else:
                print(ans-cc)