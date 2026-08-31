status = ['AC','WA','TLE','RE']
li = []

N = int(input())
for n in range(N):
  li.append(input())

for s in status:
  print(s,'x',li.count(s))