# https://codeforces.com/problemset/problem/615/A

n, m = map(int, input().split())

s = set()

for _ in range(n):
    for i in input().split()[1:]:
        s.add(i)

    if len(s) == m:
        print("YES")
        break
else:
    print("NO")

