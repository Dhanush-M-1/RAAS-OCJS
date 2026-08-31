for i in range(int(input())):
    a=int(input())
    b=list(map(int,input().strip().split()))[:a]
    if len(b)<3:
        print(-1)
    else:
        sum=b[0]+b[1]
        if sum<=b[-1]:
            print(str(1)+" "+str(2)+" "+str(len(b)))
        else:
            print(-1)