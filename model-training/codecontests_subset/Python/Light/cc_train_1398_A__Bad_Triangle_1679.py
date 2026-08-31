for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    f=0
    b=a[0]
    c=a[1]
    for i in range(n-1,-1,-1):
        if(b+c<=a[i]):
            print("1",end=' ')
            print("2",end=' ')
            print(i+1)
            f=0
            break
        else:
            f=1
    if(f==1):
        print("-1")    