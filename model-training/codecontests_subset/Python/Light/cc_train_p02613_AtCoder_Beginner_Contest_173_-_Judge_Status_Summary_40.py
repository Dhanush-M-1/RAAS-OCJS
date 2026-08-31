N = int(input())
lst = [input() for _ in range(N)]
V=["AC","WA","TLE","RE"]
for v in V:
    print("{} x {}".format(v, lst.count(v)))