a=int(input())
b=[input() for i in range(a)]
c=["AC","WA","TLE","RE"]
for value in c:
  print('{0} x {1}'.format(value, b.count(value)))


