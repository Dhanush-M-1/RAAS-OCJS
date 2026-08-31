N=int(input())
data=[input() for _ in range(N)]
for d in ["AC","WA","TLE","RE"]:
  print("{} x {}".format(d,data.count(d)))