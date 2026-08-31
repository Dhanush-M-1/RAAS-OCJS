a = int(input())
b = [input() for i in range(a)]
c =["AC", "WA", "TLE", "RE"]
for i in c:
  print(i+str(" x ")+str(b.count(i)))