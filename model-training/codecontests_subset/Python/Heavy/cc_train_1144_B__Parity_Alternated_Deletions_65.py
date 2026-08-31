n=int(input())
s=str(input())
lt=s.split(" ")
l=[]
for i in range(n):
	l.append(int(lt[i]))
odd=0
even=0
for i in l:
	if i%2==0:
		even+=1
	else:
		odd+=1
summ=0
if (even==odd or abs(even-odd)==1):
	print(summ)
else:
	mini=min(odd,even)
	temp=[]
	if mini==odd:
		for i in l:
			if i%2==0:
				temp.append(i)
		temp.sort()
		run=even-(odd+1)
		for i in range(run):
			summ+=temp[i]
		print(summ)
	else:
		for i in l:
			if i%2!=0:
				temp.append(i)
		temp.sort()
		run=odd-(even+1)
		for i in range(run):
			summ+=temp[i]
		print(summ)
	




