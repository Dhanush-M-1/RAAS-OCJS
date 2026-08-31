dic = {"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(int(input())):
  dic[input()]+=1
for i in ["AC","WA","TLE","RE"]:
  print(i+" x "+str(dic[i]))