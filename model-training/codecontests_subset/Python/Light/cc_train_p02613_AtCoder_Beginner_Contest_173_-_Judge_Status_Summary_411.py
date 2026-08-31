N=int(input())
ans={'AC':0,'WA':0,'TLE':0,'RE':0}
for i in range(N):
  ans[input()]+=1
 
for k,v in ans.items():
  print('{} x {}'.format(k,v))