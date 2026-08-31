n, k = map(int, input().split())
arr = [[int(i) for i in input().split()] for _ in range(n)]
a = sorted([arr[i][0] for i in range(n) if arr[i][1] == 1 and arr[i][2] == 0])
b = sorted([arr[i][0] for i in range(n) if arr[i][1] == 0 and arr[i][2] == 1])
ab = sorted([arr[i][0] for i in range(n) if arr[i][1] == 1 and arr[i][2] == 1])

ans = 0
l, r = 0, 0
for i in range(k):
    v1 = 10 ** 9
    if len(a) > l and len(b) > l:
        v1 = a[l] + b[l]
    v2 = 10 ** 9
    if len(ab) > r:
        v2  = ab[r]
    if v1 == v2 == 10 ** 9:
        ans = -1
        break
    if v1 < v2:
        l += 1
        ans += v1
    else:
        r += 1
        ans += v2
print(ans)
    
        
