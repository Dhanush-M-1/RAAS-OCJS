from math import log2
for _ in range(int(input())):
    # x,y,n = map(int,input().split())
    n = int(input())
    if n==1:
        print(0)
    elif n%3==0:
        three=0
        while(1):
            temp=n
            temp=temp/3
            if(temp == int(temp)):
                three+=1
                n=temp
            else:
                break
        two = log2(n)
        if two == int(log2(n)):
            if three>=two:
                print(int(three+(three-two)))
            else:
                print(-1)
        else:
            print(-1)
    else:
        print(-1)