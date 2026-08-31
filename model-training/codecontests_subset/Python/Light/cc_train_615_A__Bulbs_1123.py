n,m=map(int,input().split())
L=[]
for _ in range(n):
   s=list(map(int,input().split()))
   s.remove(s[0])
   s1=set(s)
   for i in s1:
      L.append(i)
for i in range(1,m+1):
   if i not in L:
      print("NO")
      break
else:
   print("YES")
   