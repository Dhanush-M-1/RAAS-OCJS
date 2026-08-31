n = int(input())
line1 = [int(x) for x in input().split()]
line2 = [int(x) for x in input().split()]
line3 = [int(x) for x in input().split()]
s1 = set(line1) - set(line2)
s2 = set(line2) - set(line3)
if s1:
  for x in s1:
    print(int(x))
if s2:
  for x in s2:
      print(int(x))
if not s1:
  for x in line1:
    if x not in line2 or line1.count(x) > line2.count(x):
      print(x)
      break
if not s2:
  for a in line2 :
    if a not in line3 or line2.count(a) > line3.count(a):
      print(a)
      break