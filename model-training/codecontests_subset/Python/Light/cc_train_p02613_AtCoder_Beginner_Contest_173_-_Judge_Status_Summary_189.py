N = int(input())
lst = [input() for _ in range(N)]
for i in ["AC", "WA", "TLE", "RE"]:
  print(f"{i} x {lst.count(i)}")