N=int(input())
S=[input() for i in range(N)]
for i in ["AC","WA","TLE","RE"]:
  print("{0} x {1}".format(i, S.count(i)))