import math
T=int(input())
for _ in range(T):
    n=int(input())
    m=n
    if(n==1):
        print(0)
    else:
        two=0
        three=0
        flag=0
        while(flag!=1):
            if(n%2==0):
                n=n//2
                two+=1
            else:
                flag=1
        while(flag!=0):
            if(n%3==0):
                n=n//3
                three+=1
            else:
                flag=0
        if(two==0 and three==0):
            print(-1)
        elif(two>three):
            print(-1)
        elif(math.pow(2,two)*math.pow(3,three)!=m):
            print(-1)
        else:
            p=(three-two)+three
            print(p)