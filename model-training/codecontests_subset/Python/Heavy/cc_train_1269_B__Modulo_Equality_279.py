def check(i, j, dj):
    val = d[i][j]
    while i < n:
        if d[i][j] == val:
            i+=1
            j+=dj
            j%=n
        else:
            break
    if i == n:
        return True
    return False
n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
b.sort()
d = [[0 for i in range(n)] for i in range(n)]
for i in range(n):
    for j in range(n):
        d[i][j] = (b[j] - a[i])%m
ans = []
for x in range(n):
    i, j = 0, x
    if check(i, j, 1) or check(i, j, -1):
        ans.append(d[i][j])
print(min(ans))