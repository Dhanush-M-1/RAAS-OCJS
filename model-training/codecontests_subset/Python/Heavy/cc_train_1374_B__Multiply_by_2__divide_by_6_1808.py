for _ in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
    elif n==3:
        print(2)
    elif n<6:
        print(-1)
    else:
        ans=0
        c=0
        while(1):
            if n==1:
                break
            elif n>1000000000:
              ans=-1
              break
            elif n%6==0:
                n=n//6
                c+=1
            else:
                n=n*2
                c+=1
        if ans==-1:
            print(-1)
        else:
            print(c)



