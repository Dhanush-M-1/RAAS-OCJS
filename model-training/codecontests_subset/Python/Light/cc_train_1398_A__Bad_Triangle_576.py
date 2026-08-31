t = int(input())
for _ in range(t):
    n = int(input())
    arr = [int(i) for i in input().split()]
    if arr[0]+arr[1] <= arr[-1]:
        print(0+1,1+1,n)
    else:
        print(-1)
