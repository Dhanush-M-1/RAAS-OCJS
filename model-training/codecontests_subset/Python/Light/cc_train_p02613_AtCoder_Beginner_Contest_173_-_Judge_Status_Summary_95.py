N = int(input())

cnt = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for i in range(N):
  cnt[input()]+=1
  
for k,v in cnt.items():
  print(k,'x',v)