n=int(input())
d={'AC':0,'WA':0,'TLE':0,'RE':0}
for _ in range(n): s=input(); d[s]+=1
for k in d: print(k,'x',d[k])