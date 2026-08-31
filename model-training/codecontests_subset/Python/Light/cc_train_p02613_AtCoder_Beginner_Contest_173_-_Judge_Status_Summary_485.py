n=int(input())
di={'AC':0,'WA':0,'TLE':0,'RE':0}
for i in range(n):
  s=input()
  di[s]+=1
for i in di.keys():
  print("{} x {}".format(i,di[i]))