t = int(input())
d = {'AC':0, 'WA':0,'TLE':0, 'RE':0}

while t:
  d[input()]+=1
  
  t-=1
  
for i in d:
  print(i,'x',d[i])