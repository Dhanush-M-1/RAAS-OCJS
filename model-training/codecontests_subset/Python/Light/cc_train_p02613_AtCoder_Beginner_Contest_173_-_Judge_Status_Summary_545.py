l={'AC':0,'WA':0,'TLE':0,'RE':0}

n=int(input())
for i in range(n):
  l[input()]+=1
for i in l:
  print(i,"x",l[i])