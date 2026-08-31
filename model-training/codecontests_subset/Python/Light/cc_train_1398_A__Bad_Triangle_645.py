for i in range(int(input())):
    n=int(input())
    x=list(map(int,input().split()))
    if x[0]+x[1]>x[-1]:
        print(-1)
    else:
        print(1,2,n)    
