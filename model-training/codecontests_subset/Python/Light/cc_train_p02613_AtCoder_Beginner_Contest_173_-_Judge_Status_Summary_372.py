N = int(input())
a1 = []
for i in range(N):
  a1.append(input())

a2 = ["AC", "WA", "TLE", "RE"]
for i in a2:
  print(i + " x " + str(a1.count(i)))