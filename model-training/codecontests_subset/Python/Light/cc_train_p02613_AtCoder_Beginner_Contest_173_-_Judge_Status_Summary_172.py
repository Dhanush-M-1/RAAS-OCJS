n = int(input())
d = {"AC": 0, "WA": 0, "TLE": 0, "RE": 0}
for _ in range(n):
    d[input()] += 1
for k, v in d.items():
    print(k," x ", str(v))