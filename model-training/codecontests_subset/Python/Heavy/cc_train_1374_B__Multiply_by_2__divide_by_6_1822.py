for i in range(int(input())):
    n=int(input())
    count=0
    flag=True
    while True:
        if n==1:
            break
        elif n==3:
            count+=2
            break
        elif n==2 or n==4 or n==5:
            print(-1)
            flag=False
            break
        elif (n%6)==0:
            n=n/6
            count+=1
        elif ((n*2)%6)==0:
            n=(n*2)/6
            count+=2
        else:
            flag=False
            print(-1)
            break
    if flag==True:
        print(count)