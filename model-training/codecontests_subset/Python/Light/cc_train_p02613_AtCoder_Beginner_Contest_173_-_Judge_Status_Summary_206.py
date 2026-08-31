n,*a=open(0).read().split()
d={"AC":0,"WA":0,"TLE":0,"RE":0}
for i in a:
  d[i]=d.get(i,0)+1
for i,j in d.items():
     print(i,"x",j)