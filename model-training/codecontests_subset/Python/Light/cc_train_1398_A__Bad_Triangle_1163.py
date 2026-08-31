import sys
input = sys.stdin.readline
I = lambda : list(map(int,input().split()))

m,=I()
while m:
    m-=1
    n,=I()
    arr=I()
    a=b=c=0
    flag=0
    for i in range(n-1,1,-1):
        if arr[0]+arr[1]<=arr[i]:
            print(1,2,i+1)
            flag=1
            break

    if flag==0:
        print(-1)
