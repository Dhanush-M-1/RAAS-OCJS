n = int(input())
S = [input() for i in range(n)]
scores = ["AC", "WA", "TLE", "RE"]

for score in scores:
    print(f"{score} x {S.count(score)}")
