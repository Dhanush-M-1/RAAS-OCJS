z=int(input())
for h in range(z):
    n=int(input())
    cnt=0
    while True:
        if n<=6:
            if n==3:
                cnt+=2
                n=1
            if n==6:
                cnt+=1
                n=1
            break
        else:
            if n%6==0:
                n=n//6
                cnt+=1
            elif (n*2)%6==0:
                n=(n*2)//6
                cnt+=2
            else:
                break
    if n==1:
        print(cnt)
    else:
        print(-1)