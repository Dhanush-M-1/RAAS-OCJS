L = {'AC':0,'WA':0,'TLE':0,'RE':0}
 
n = int(input())
for i in range(n):
  L[input()] += 1
for i in L:
  print(i,"x",L[i])