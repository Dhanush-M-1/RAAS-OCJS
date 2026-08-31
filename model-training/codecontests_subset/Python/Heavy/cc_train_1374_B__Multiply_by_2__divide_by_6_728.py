t=int(input())
while(t>0):
    n=int(input())
    flag=0
    cnt=0
    if(n==1):
        print(0)
    elif(n==2):
        print(-1)
    elif(n%3!=0):
        print(-1)
    else:
        while(1):
            if(n==1):
                break
            elif(n==2):
                flag=1
                break
            if(n%3!=0):
                flag=1
                break
            if(n%6==0):
                n=n//6
            else:
                n=n*2
            cnt+=1
        if flag==0:
            print(cnt)
        else:
            print(-1)
        

    t-=1

