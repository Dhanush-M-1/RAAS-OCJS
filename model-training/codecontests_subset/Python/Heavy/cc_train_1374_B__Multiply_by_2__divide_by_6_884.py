t=int(input())
for p in range(t):
    ans=0
    n=int(input())
    if n==1:
        ans=0
    else:
        while(True):
            if n<3:
                ans=-1
                break
            else:
                if (n*2)%6!=0:
                    ans=-1
                    break
                if n%6==0:
                    n=n//6
                    ans+=1
                else:
                    n=n*2
                    ans+=1
                if n==1:
                    break
    print(ans)
        
