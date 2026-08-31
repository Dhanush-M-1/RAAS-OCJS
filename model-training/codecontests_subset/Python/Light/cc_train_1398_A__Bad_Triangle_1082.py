for _ in range(int(input())):
    n=int(input())
    ar=list(map(int,input().split()))
    count=1
    for i in range(2,n):
        if ar[i]>=ar[0]+ar[1]:
            print(1,2,i+1)
            count=0
            break
    if count==1:
        print(-1)