import sys

si = True
i=0
j=0
n=[]
an=[]
m=None

for line in sys.stdin:
  l = line.split()
  if(len(l)!=0):
    #print(l)
    if(i==0):
      m=int(l[1])
      for x in range(m):
        n.append(x+1)
      #print("n=", n)
      
    else:
      for x in range(int(l[0])):
        #print("'", l[x+1], "'")
        if(int(l[x+1]) in n and not int(l[x+1]) in an):
          #print("true")
          an.append(int(l[x+1]))
          j+=1
        else: si = False
    i+=1
    #print(i)
    
  else: break
#print("n=", n)
#print("an=", an)

#print("j= ", j)
if(len(an)==len(n)): print("YES") 
else: print("NO")