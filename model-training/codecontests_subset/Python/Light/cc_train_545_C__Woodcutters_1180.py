n=int(input())
if n==1:
	print('1')
else:
	o=2
	q=[]
	w=[]
	for i in range(n):
		x,h=[int(m) for m in input().split()]
		q.append(x)
		w.append(h)
	for i in range(1,n-1):
		if q[i-1]<(q[i]-w[i]):
			o+=1
		elif q[i-1]>=(q[i]-w[i]) and (q[i]+w[i])<q[i+1]:
			o+=1
			d=q[i]+w[i]
			q.pop(i)
			q.insert(i,d)
		else:
			o=o		
	print(o)
