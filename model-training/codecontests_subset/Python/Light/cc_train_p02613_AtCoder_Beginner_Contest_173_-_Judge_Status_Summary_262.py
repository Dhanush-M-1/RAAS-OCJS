N = int(input())
S = [input() for _ in range(N)]

for s in ["AC", "WA", "TLE", "RE"]:
  print("%s x %s"%(s, S.count(s)))
