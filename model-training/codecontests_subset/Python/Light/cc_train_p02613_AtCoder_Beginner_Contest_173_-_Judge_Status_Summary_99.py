n = int(input())
l = [input() for i in range(n)]
for s in ["AC", "WA", "TLE", "RE"]:
    print(f"{s} x {l.count(s)}")