mod = 10 ** 9 + 7
ii = lambda : int(input())
si = lambda : input()
dgl = lambda : list(map(int, input()))
f = lambda : map(int, input().split())
il = lambda : list(map(int, input().split()))
ls = lambda : list(input())
n=ii()
l=il()
el,ol=[],[]
for i in range(n):
   if l[i]&1:
      ol.append(l[i])
   else:
      el.append(l[i])
ol.sort(reverse=True)
el.sort(reverse=True)
l1,l2=len(ol),len(el)
if l1>l2+1:
   print(sum(ol[-(l1-l2-1):]))
elif l2>l1+1:
   print(sum(el[-(l2-l1-1):]))
else:
   print(0)
