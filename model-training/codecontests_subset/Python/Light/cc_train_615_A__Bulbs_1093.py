li=[int(n) for n in input().split()]
num=[]
c=1
while li[0]>0:
    l=[int(n) for n in input().split()]
    num.extend(l[1:])
    li[0]-=1

for i in range(1,li[1]+1):
    if (i not in num):
        c=0
        break

if c==0:
    print("NO")
else:
    print("YES")
				   	     			 			 		   	 	 	