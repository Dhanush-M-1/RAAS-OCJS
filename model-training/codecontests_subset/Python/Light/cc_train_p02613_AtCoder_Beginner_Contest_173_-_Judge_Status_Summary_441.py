n = int(input())
a = [input() for i in range(n)]
for i in ["AC", "WA", "TLE", "RE"]:
  print(i + " x " + str(a.count(i)))
