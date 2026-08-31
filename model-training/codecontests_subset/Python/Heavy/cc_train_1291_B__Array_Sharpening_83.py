t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    left = [1] + [0]*(n-1)
    right = [0]*(n-1) + [1]

    for i in range(1, n):
        if a[i] >= i:
            left[i] |= left[i-1]
    for i in range(n-2, -1, -1):
        if a[i] >= n-i-1:
            right[i] |= right[i+1]

    for k in range(n):
        if a[k] >= max(k, n-k-1) and (left[k-1] if k > 0 else 1) and (right[k+1] if k < n-1 else 1):
            print('Yes')
            break
    else:
        print('No')
