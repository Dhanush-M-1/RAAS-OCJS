n = int(input())
s = [input() for _ in range(n)]
res = ["AC", "WA", "TLE", "RE"]

for r in res:
    print(r, "x", s.count(r))