test = int(input())
for _ in range(test):
    n = int(input())
    arr = list(map(int, input().split()))
    t = arr[0]+arr[1]
    o = arr[-1]
    if t<=o:
        print(1, end=' ')
        print(2, end=' ')
        print(n)
    else:
        print(-1)