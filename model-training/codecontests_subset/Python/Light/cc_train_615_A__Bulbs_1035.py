n, m = map(int, input().split())
r = set(range(1, m+1))
for i in range(n):
    a = set(map(int, input().split()[1:]))
    r = r - a
print("YES" if len(r)==0 else "NO")
