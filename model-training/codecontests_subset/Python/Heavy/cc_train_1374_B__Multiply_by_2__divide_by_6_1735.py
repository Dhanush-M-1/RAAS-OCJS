t=int(input())
for _ in range(t):
    n=int(input())
    if n==1:
        print(0)
    else:
        two=True
        three=True
        twocount=0
        threecount=0
        q=n
        while two or three:
            if q%2==0:
                twocount+=1
                q/=2
            else:
                two=False
            if  q%3==0:
                threecount+=1
                q/=3
            else:
                three=False
        if q!=1:
            print(-1)
        else:
            if twocount>threecount:
                print(-1)
            else:
                print(threecount-twocount+threecount)
