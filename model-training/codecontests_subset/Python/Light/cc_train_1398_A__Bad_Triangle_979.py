for _ in range(int(input())):
    n=int(input())
    ar=list(map(int,input().split()))
    flg=1
    for i in range(n-2):
        if ar[i]+ar[i+1]<=ar[n-1]:
            flg=0
            print(i+1,i+2,n)
            break
    if flg:
        print(-1)
