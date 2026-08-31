n=int(input())
result={'AC':0,'WA':0,'TLE':0,'RE':0}
for _ in range(n):
  result[input()] += 1
for i,j in result.items():
  print(f'{i} x {j}')