n=int(input())
c=list(map(int,input().split()))
c=sorted(c)[::-1]
count_even,count_odd=0,0
for i in range(len(c)):
	if c[i]%2==0:
		count_even+=1
	else:
		count_odd+=1
		

if abs(count_even-count_odd)<=1:
	print(0)
else:
	if count_even>count_odd:
		r=(count_even-count_odd)-1
		c=sorted(c)
		index=0
		tot=0
		for i in range(len(c)):
			if c[i]%2==0:
				tot+=c[i]
				index+=1
			if index==r:
				break
		print(tot)
		
		
	else:
		flag=0
		c=sorted(c)
		
		r=(count_odd-count_even)-1
		index=0
		tot=0
		for i in range(len(c)):
			if c[i]%2==1:
				tot+=c[i]
				index+=1
			if index==r:
				break
		print(tot)
		
	
