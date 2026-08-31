t = int(input())

for _ in range(t):
    n = int(input())
    array = list(map(int, input().split()))

    if array[0] + array[1] <= array[-1]:
        print(1, 2, len(array))
    else:
        print(-1)