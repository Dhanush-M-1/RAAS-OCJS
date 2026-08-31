t = int(input())
for i in range(t):
    n = int(input())
    arr = [int(x) for x in input().split()]
    if (arr[0] + arr[1] > arr[n - 1]):
        print("-1")
    else:
        print(1,2,n)
