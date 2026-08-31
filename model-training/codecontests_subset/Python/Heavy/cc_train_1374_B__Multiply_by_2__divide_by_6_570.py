for _ in range(int(input())):
    n=int(input())
    if(n%3==0):
        cnt=0
        flg=False
        while(True):
            if(n%3!=0 and n!=1):
                flg=True
                break
            elif(n==1):
                flg=False
                break
            elif(n%6==0):
                n//=6
            else:
                n*=2
            cnt+=1
        if(flg==False):
            print(cnt)
        else:
            print(-1)
    elif(n==1):
        print(0)
    else:
        print(-1)