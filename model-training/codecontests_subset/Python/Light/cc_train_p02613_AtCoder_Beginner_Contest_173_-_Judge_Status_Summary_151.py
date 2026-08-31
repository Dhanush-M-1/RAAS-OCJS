N = int(input())
S = [input() for i in range(N)]

for k in ["AC", "WA", "TLE", "RE"]:
    print(f"{k} x {S.count(k)}")
