q = int(input())
for i in range(q):
    n = int(input())
    if n == 1:
        n = input()
        print(0)
        continue
    arr = []
    for j in range(n):
        start, end = map(int, input().split())
        arr.append((start, end))
    arr.sort(key=lambda x: x[1])
    flag = 0
    maxims = 0
    for it in arr:
        if it[0] > arr[0][1]:
            flag = 1
            if it[0] > maxims:
                maxims = it[0]
    if flag:
        print(maxims - arr[0][1])
    else:
        print(0)
