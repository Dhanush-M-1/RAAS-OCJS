n=int(input())
s=[input() for i in range(n)]
for a in ["AC", "WA", "TLE", "RE"]:
    print(f"{a} x {s.count(a)}")