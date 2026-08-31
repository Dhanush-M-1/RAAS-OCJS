N = int(input())
count = {'AC':0,'WA':0,'TLE':0,'RE':0}
for n in range(N):
  count[input()]+=1
for i in count:
  print(i,'x',count[i])