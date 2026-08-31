n,k=map(int,input().split())
L1=[]
L2=[]
L3=[]
for i in range(n):
   t, a, b = map(int, input().split())
   if a==1 and b==1:
      L1.append(t)
   elif a==1 and b==0:
      L2.append(t)
   elif a==0 and b==1:
      L3.append(t)
L3.sort()
L2.sort()
for i in range(min(len(L2), len(L3))):
	L1.append(L2[i]+L3[i])
if k<=len(L1):
   L1.sort()
   print(sum(L1[:k]))
else:
   print(-1)