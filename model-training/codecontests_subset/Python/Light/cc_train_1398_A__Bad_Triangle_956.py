for _ in range(int(input())) :
    n =int(input())
    a = list(map(int,input().split()))
    x = True
    for i in range(1,n) :
        if a[i] + a[0] <= a[-1] :
            print(1,i+1,n,sep=" ")
            x = False 
            break
    if x : print(-1)    