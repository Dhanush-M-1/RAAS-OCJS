for i in range(int(input())):
    n=int(input())
    cnt=0
    if n==1:
        print(cnt)
    elif n<6 and n%3!=0:
        print(-1)
        
    elif n>=6 or n%3==0:
        while n!=1:
            if n>=6 and n%6==0:
                n=n//6
                cnt+=1
            elif n>6 and n%3==0:
                n=n*2
                cnt+=1
            elif n<6 and n%3==0:
                n=n*2
                cnt+=1
            elif n<6 and n%3==0:
                n=n*2
                cnt+=1
            else:
                print(-1)
                break
        else:
            print(cnt)