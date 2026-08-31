l1=[]
l2=[]
n=int(input())
l=[int(n) for n in input().split()]
for i in range (0,n):
     if l[i]>500000:
          l2.append(l[i])
     else:
          l1.append(l[i])
if len(l1)!=0:
     l1.sort()
if len(l2)!=0:
     l2.sort()
if len(l1)==0:
     print(1000000-l2[0])
elif len(l2)==0:
     print(l1[len(l1)-1]-1)
elif l1[len(l1)-1]-1>1000000-l2[0]:
     print(l1[len(l1)-1]-1)
else:
     print(1000000-l2[0])