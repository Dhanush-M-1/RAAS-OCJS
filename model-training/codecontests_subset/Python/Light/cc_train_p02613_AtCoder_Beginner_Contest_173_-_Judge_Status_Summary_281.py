dict={"AC":0,"WA":0,"TLE":0,"RE":0}
n,*s=map(str,open(0).read().split())
for i in s:
  dict[i]+=1
for k, v in dict.items(): 
  print(k+" x "+str(v))