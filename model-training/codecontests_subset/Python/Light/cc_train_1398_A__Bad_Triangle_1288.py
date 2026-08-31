t = int(input())
for _ in range(t):
    n = int(input())
    arr = [int(num) for num in input().split(' ')]
    if arr[0]+arr[1]>arr[-1]:
        print(-1)
    else:
        print(1,end=' ')
        print(2,end=' ')
        print(n)