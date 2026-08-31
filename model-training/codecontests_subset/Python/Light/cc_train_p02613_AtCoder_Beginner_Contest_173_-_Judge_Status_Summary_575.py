N =int(input())
list ={"AC":0, "WA":0, "TLE":0, "RE":0 }
 
l=[input() for i in range(N)]

for i in list:
  print('{0} x {1}'.format(i, l.count(i)))