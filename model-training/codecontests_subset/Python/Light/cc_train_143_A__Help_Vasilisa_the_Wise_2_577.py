def check (p,q,r,s):
   if 0<int(p)<=9 and 0<int(q)<=9 and 0<int(r)<=9 and 0<int(s)<=9:
       return True
r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
for i in range(1,r1+1):
    l1 = []
    l2 = []
    l1.append(i)
    l1.append(r1-i)
    l2.append(c1-i)
    l2.append(c2-l1[1])
    if len(set(l1+l2))==4 and check(l1[0],l1[1],l2[0],l2[1])==True:
         if sum(l2)==r2 and (l1[0]+l2[1])==d1 and (l2[0]+l1[1])==d2:
             print(*l1)
             print(*l2)
             exit()
    else:
        continue
print('-1')
