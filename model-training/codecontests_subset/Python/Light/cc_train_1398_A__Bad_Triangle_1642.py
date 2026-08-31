for i in range(0,int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    f=0
    for j in range(2,n):
        if(a[0]+a[1]>a[j]):
            continue
        else:
            f=1
            print(1,2,j+1)
            break
    if(f==0):
        print("-1")