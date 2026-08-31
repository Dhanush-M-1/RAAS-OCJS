def func(arr,a):
    if arr[0] + arr[1] <= arr[-1]:
        print(1,2,a)
    else:
        print(-1)

t = int(input())
for _ in range(t):
    a = int(input())
    arr = list(map(int, input().split()))
    func(arr,a)