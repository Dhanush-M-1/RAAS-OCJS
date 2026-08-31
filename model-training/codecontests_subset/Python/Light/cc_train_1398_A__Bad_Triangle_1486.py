def A(arr):
    if arr[0] + arr[1] <= arr[len(arr)-1]:
        print(1,  2, len(arr))
    else:
        print(-1)
count = int(input())
for i in range(count):
    lne = int(input())
    arr = list(map(int, input().split()))
    A(arr)