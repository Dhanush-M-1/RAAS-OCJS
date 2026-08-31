t = int(input())
for _ in range(t):
    l = int(input())
    arr = [int(p) for p in input().split()]
    possible = -1
    count = 0
    a1 = arr[0]
    a2 = arr[1]
    for i in range(2, len(arr)):
        if arr[i] >= a1 + a2:
            print(1, 2, i+1)
            count += 1
            break
    if not count:
        print(possible)