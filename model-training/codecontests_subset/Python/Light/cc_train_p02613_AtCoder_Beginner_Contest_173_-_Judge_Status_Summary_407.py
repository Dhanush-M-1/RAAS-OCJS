l = []
for i in range(int(input())):
  l.append(input())
for x in ["AC", "WA", "TLE", "RE"]:
  print(x + " x " + str(l.count(x)))