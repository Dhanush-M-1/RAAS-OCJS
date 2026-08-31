t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    s=a[0]+a[1]
    sa=a[n-1]
    if s<=sa :
        print("{} {} {}".format(1,2,n))
    else:
        print('-1')