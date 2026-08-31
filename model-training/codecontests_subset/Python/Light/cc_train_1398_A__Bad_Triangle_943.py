t=int(input())
for i in range (0,t):
    n=int(input())
    arr = list(map(int, input().split()))
    for j in range (0,n):
        a=int(arr[0])
        b=int(arr[1])
        c=int(arr[n-1])

    if (a + b > c):
        print(-1)
    else:
        print(1, 2, n)
    # print(a, b, c)