n = int(input())
dict = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for _ in range(n):
  dict[input()] += 1
for i in dict:
  print(i, 'x', dict[i])