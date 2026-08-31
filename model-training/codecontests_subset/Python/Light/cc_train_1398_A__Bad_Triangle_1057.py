for x in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    i=0
    if a[i]+a[i+1]<=a[n-1]:
        print(i+1,i+2,n)
    else:
        print('-1')
