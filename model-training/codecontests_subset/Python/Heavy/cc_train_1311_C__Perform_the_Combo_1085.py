t = int(input())
for i in range(t):
	n,m = list(map(int, input().strip().split()))
	s = input()
	p = list(map(int, input().strip().split()))

	temp=[]
	for j in s:
		temp.append(0)

	for j in range(m):
		temp[0]+=1
		if(p[j]<n):
			temp[p[j]]-=1

	ans = [0]*n
	for j in range(n):
		if j==0:
			ans[j] = temp[j] + 1
		else:
			ans[j] = ans[j-1] + temp[j]

	for k in 'abcdefghijklmnopqrstuvwxyz':
		if k in s:
			count=0
			pos = s.find(k)
			# print('done')
			while(pos>=0):
				count+=ans[pos]
				pos = s.find(k, pos+1)
			print(count, end=' ')
		else:
			print(0, end=' ')
	print()
