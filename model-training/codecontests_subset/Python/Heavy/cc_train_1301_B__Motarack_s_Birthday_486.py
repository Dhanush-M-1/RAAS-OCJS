num_t = int(input())

for _ in range(num_t):
    input()
    arr = [int(i) for i in input().split()]
    
    min_p = float('inf')
    max_p = float('-inf')
    found = False
    for i in range(len(arr)):
        if arr[i] == -1 and i - 1 >= 0 and arr[i - 1] != -1:
            min_p = min(arr[i - 1], min_p)
            max_p = max(arr[i - 1], max_p)
            found = True
        if arr[i] == -1 and i + 1 < len(arr) and arr[i + 1] != -1:
            min_p = min(arr[i + 1], min_p)
            max_p = max(arr[i + 1], max_p)
            found = True

    if not found:
        print (0, 0)
        continue

    k = (max_p + min_p) // 2

    m = float('-inf')
    for i in range(1, len(arr)):
        if arr[i] != -1 and arr[i - 1] != -1:
            m = max(abs(arr[i] - arr[i - 1]), m)

    print (max(m, max_p - k, k - min_p), k)
