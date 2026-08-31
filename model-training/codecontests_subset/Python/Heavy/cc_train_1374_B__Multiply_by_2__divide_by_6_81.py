# cook your dish here
t=int(input())
for _ in range(t):
    n=int(input())
    if n==1:
        print(0)
        continue
    else:
        ans=0
        f=0
        while n>1:
            if n%3!=0:
                f=1
                break
            else:
                if n%6==0:
                    n=n//6
                    ans=ans+1
                else:
                    ans=ans+2
                    n=n//3
            if n==1:
                break
        if f==0:
            print(ans)
        else:
            print(-1)
        