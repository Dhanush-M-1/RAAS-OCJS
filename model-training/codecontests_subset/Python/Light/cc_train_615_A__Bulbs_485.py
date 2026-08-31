n, m = map(int, input().split())
s = {}
for i in range(n):
    x = list(map(int, input().split()))
    for y in x[1 :]:
        s[y] = True
print("YES" if all(False if not y in s.keys() else True for y in range(1, m + 1)) else "NO")