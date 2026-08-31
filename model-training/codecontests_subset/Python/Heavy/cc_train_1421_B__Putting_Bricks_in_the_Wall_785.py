cases=int(input())
for _ in  range(cases):
	n=int(input())
	s=[]
	for i in range(n):
		s.append(list(input()))
	#print(2)
	#print(s)
	
	l1=[s[0][1],s[1][0]]
	l2=[s[n-2][n-1],s[n-1][n-2]]
	if l1[0]=='0' and l1[1]=='0' and l2[0]=='0' and l2[1]=='0':
		print(2)
		print(0+1,1+1)
		print(1+1,0+1)
	if l1[0]=='0' and l1[1]=='1' and l2[0]=='0' and l2[1]=='0':
		print(1)
		print(0+1,1+1)
	if l1[0]=='1' and l1[1]=='0' and l2[0]=='0' and l2[1]=='0':
		print(1)
		print(1+1,0+1)
	if l1[0]=='1' and l1[1]=='1' and l2[0]=='0' and l2[1]=='0':
		print(0)
	if l1[0]=='0' and l1[1]=='0' and l2[0]=='0' and l2[1]=='1':
		print(1)
		print(n-2+1,n-1+1)
	if l1[0]=='0' and l1[1]=='1' and l2[0]=='0' and l2[1]=='1':
		print(2)
		print(0+1,1+1)
		print(n-1+1,n-2+1)
	if l1[0]=='1' and l1[1]=='0' and l2[0]=='0' and l2[1]=='1':
		print(2)
		print(0+1,1+1)
		print(n-2+1,n-1+1)
	if l1[0]=='1' and l1[1]=='1' and l2[0]=='0' and l2[1]=='1':
		print(1)
		print(n-1+1,n-2+1)
	if l1[0]=='0' and l1[1]=='0' and l2[0]=='1' and l2[1]=='0':
		print(1)
		print(n-1+1,n-2+1)
	if l1[0]=='0' and l1[1]=='1' and l2[0]=='1' and l2[1]=='0':
		print(2)
		print(0+1,1+1)
		print(n-2+1,n-1+1)
		
		
	if l1[0]=='1' and l1[1]=='0' and l2[0]=='1' and l2[1]=='0':
		print(2)
		print(0+1,1+1)
		print(n-1+1,n-2+1)
	if l1[0]=='1' and l1[1]=='1' and l2[0]=='1' and l2[1]=='0':
		print(1)
		print(n-2+1,n-1+1)
	if l1[0]=='0' and l1[1]=='0' and l2[0]=='1' and l2[1]=='1':
		print(0)
	if l1[0]=='0' and l1[1]=='1' and l2[0]=='1' and l2[1]=='1':
		print(1)
		print(1+1,0+1)
		
	if l1[0]=='1' and l1[1]=='0' and l2[0]=='1' and l2[1]=='1':
		print(1)
		print(0+1,1+1)
	if l1[0]=='1' and l1[1]=='1' and l2[0]=='1' and l2[1]=='1':
		print(2)
		print(0+1,1+1)
		print(1+1,0+1)

	
