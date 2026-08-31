n = int(input())
d = {"AC":0, "WA":0, "TLE":0, "RE":0}
for i in range(n):
  d[input()] += 1
for i in d.keys():
  print(i,"x",d[i])