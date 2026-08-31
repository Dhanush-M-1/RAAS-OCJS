n = int(input())
s = [input() for i in range(n)]
a = ["AC","WA","TLE","RE"]
for i in a:
  print(i,'x',s.count(i))