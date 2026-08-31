r={i:0 for i in ["AC","WA","TLE","RE"]}
for _ in range(int(input())):
  s=input()
  r[s]+=1
for i in ["AC","WA","TLE","RE"]:
  print(i,"x",r[i])
