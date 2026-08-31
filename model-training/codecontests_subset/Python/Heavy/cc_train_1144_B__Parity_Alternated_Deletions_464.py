def countSetBits(n): 

	count = 0
	while (n): 
		n &= (n-1) 
		count+=1
	
	return count 

L1=[]
L2=[]
n=int(input())
L=[int(x) for x in input().split()]
for i in L:
    c=countSetBits(i)
    if i%2==0:
        L2.append(i)
    else:
        L1.append(i)
L1=sorted(L1)
L2=sorted(L2)

status=0
if len(L1)==len(L2):
    print(0)
    status=1
elif max(len(L1),len(L2))-min(len(L1),len(L2))==1:
    print(0)
    status=1
elif len(L1)>len(L2):
    c1=len(L1)-1
    c2=c1-len(L2)
    Add=0
    for x1 in range(0,c2):
        Add+=L1[x1]
elif  len(L2)>len(L1):
    c1=len(L2)-1
    c2=c1-len(L1)
    Add=0
    for x2 in range(0,c2):
        Add+=L2[x2]
if status==0:
    print(Add)
