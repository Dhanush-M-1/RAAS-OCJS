def swap(c, i, j):
	
	c = list(c)
	#print(c[i],c[j])
	c[i], c[j] = c[j], c[i]
	#print(c)
	return ''.join(c)
for i in range(int(input())):
	index1=-1
	index2=-1
	m,n= map(str,input().split())
	if (m<n):
		print(m)

		continue
	original = m
	#print(m,n)
	m=sorted(m)
	#print(str(m))
	if(m[0]>n[0]):
		print("---")
		continue
	z=0
	for j in range (len(m)):
		#print(m[j],original[j])
		if (m[j]!=original[j]):
			index1=j
			#print(index1,m[j],original[j])
			for k in range (j+1,len(m)):
				if(original[k]==m[j]):
					index2=k
			#print(index1,index2)
			original = swap(original,index1,index2)
			break
	if (original<n):
		print(original)
	else:
		print("---")

