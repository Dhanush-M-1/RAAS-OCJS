n = int(input())
arr = list(map(int, input().split()))
if n == 1:
    print("1 1")
    print(-arr[0])
    print("1 1")
    print("0")
    print("1 1")
    print("0")
else:
    print("1 " + str(n-1))
    for i in range(len(arr)-1):
        print(arr[i]%n*(n-1), end=" ")
        arr[i] += arr[i]%n*(n-1)
    print()
    print(str(n) + " " + str(n))
    print(n-arr[-1]%n)
    arr[-1] += n - arr[-1]%n
    print("1 " + str(n))
    for i in range(len(arr)):
        print(-arr[i], end=" ")
    print()

    