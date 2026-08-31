x,y=[int(a) for a in input().split()]
a=[]
for i in range(x):
   z=[int(a) for a in input().split()]
   z.pop(0)
   for i in z:
       a.append(i)
if len(set(a))==y:
    print("YES")
else:
    print("NO")