from collections import defaultdict
from string import ascii_lowercase
def res(n,m,s,l):
   d=defaultdict(lambda :0)
   l=sorted(l)
   for z in s[:l[0]]:
      d[z] += 1 * (m)
   for v in range(1,m):
      x=s[l[v-1]:l[v]]
      for z in x:
         d[z] += 1*(m-v)
   for z in s:
      d[z]+=1
   return d


t=int(input())
for i in range(t):
   n,m=[int(x) for x in input().split()]
   s=input()
   l=[int(x) for x in input().split()]
   dic=res(n,m,s,l)
   for c in ascii_lowercase:
      print(dic[c],end=" ")
   print("\n")
