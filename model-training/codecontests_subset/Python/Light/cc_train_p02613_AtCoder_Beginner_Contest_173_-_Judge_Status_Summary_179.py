a = int(input())
b = [input() for i in range(a)]
c = ["AC", "WA", "TLE", "RE"]
for d in c:
  print(f"{d} x {b.count(d)}")