S={'AC':0,'WA':0,'TLE':0,'RE':0}

for i in range(int(input())):
  S[input()]+=1
for k,v in S.items():
  print(k,'x',v)
