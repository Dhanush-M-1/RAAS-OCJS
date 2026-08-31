t = int(input())

for _ in range(t):
    _ = input()
    k, n, m = tuple(map(int, input().split()))
    a = tuple(map(int, input().split()))
    b = tuple(map(int, input().split()))

    ans = []
    i = 0
    j = 0
    while i + j < n + m:
        if i < n and a[i] == 0:
            ans.append(a[i])
            k += 1
            i += 1
        elif j < m and b[j] == 0:
            ans.append(b[j])
            k += 1
            j += 1
        elif i < n and a[i] <= k:
            ans.append(a[i])
            i += 1
        elif j < m and b[j] <= k:
            ans.append(b[j])
            j += 1
        else:
            ans = [-1]
            break
    print(" ".join(map(str, ans)))
