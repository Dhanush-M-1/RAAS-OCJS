import bisect
for t in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    for i in range(n-2):
        first=arr[i]
        second=arr[i+1]
        maxim_no=first+second
        if arr[-1]<maxim_no:
            print(-1)
            break
        else:
            print(i+1,i+2,n)
            break