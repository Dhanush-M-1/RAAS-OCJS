N = int(input())
Ss = [input() for i in range(N)]

for j in ["AC", "WA", "TLE", "RE"]:
  print("{} x {}".format(j, Ss.count(j)))