n=int(input())
dic={'AC':0,'WA':0,'TLE':0,'TLE':0,'RE':0}
for i in range(n):
  dic[input()]+=1
for i in dic:
  print(i,'x',dic[i])
    
  