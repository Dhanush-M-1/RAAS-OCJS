[n, m] = list(map(int, input().split(" ")))
t = [0]*(m+1)
for i in range(n):
    arr = list(map(int, input().split(" ")))
    for j in range(1, arr[0] + 1):
        t[arr[j]] = 1
print("YES" if sum(t) == m else "NO")
