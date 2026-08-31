for _ in range(int(input())):
    n, arr = int(input()), list(map(int, input().split()))
    a,b = arr[0],arr[1]
    s = a+b
    f = 1
    for i in range(2,n):
        if s <= arr[i]:
            f = 0
            print(1,2,i+1)
            break
    if f:
        print(-1)
    