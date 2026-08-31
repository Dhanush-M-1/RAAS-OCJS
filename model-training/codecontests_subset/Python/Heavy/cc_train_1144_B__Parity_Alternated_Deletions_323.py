n=int(input())
a=[int(i) for i in input().split()]
even=[]
odd=[]
for x in a:
	if x%2==0:
		even.append(x)
	else:
		odd.append(x)
even.sort()
odd.sort()
even=even[::-1]
odd=odd[::-1]
ch='e'
while not((len(even)==0 and ch=='e') or (len(odd)==0 and ch=='o')):
	if ch=='e':
		even.pop(0)
		ch='o'
	else:
		odd.pop(0)
		ch='e'
if len(even)==0:
	res1=sum(odd)
else:
	res1=sum(even)

ch='o'
while not((len(even)==0 and ch=='e') or (len(odd)==0 and ch=='o')):
	if ch=='e':
		even.pop(0)
		ch='o'
	else:
		odd.pop(0)
		ch='e'
if len(even)==0:
	res2=sum(odd)
else:
	res2=sum(even)

res=min(res1,res2)
print(res)