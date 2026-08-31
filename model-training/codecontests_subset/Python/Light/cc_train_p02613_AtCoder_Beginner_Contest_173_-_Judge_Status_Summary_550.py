n = int(input())
v = [input() for i in range(n)]

for i in ["AC", "WA", "TLE", "RE"]:
  print("{} x {}".format(i, v.count(i)))