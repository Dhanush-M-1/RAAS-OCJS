n=int(input())
l=[int(x) for x in input().split()]
l1=[int(x) for x in input().split()]
l2=[int(x) for x in input().split()]
l3,l4=[],[]
l.sort()
l2.sort()
l1.sort()
c,j=0,0
l.sort()
l2.sort()
#print(l3)
#print(l)
i,j=0,0
for i in range(n-1):
    if l[i]!=l1[i]:
        l3.append(l[i])
        break
if len(l3)!=1:
    l4.append(l[-1])
else:
    l4.append(l3[0])
#print(l3)
l3=[]
for i in range(n-2):
    if l2[i]!=l1[i]:
        l3.append(l1[i])
        #print(l2[i])
        break
if len(l3)!=1:
    l4.append(l1[-1])
else:
    l4.append(l3[0])
#print(l3)
print(l4[0],l4[1],sep='\n')
    
    
    
    
    
