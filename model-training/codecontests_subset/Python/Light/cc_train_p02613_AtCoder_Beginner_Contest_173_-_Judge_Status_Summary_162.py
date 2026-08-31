d={'AC':0,'WA':0,'TLE':0,'RE':0}
n=int(input())
for i in range(n):
  s=input()
  d[s]+=1
for i in list(d):
  print(i,'x',d[i])