try:   
    for i1 in range(int(input())):
        n=int(input())
        a=list(map(int,input().split()))
        t=0
        if a[0]+a[1]<=a[-1] :
            print(1,2,n)
        else:
            print(-1)
except:
    pass