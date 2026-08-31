T = int(input())
for tt in range(T):
	[n,m] = [int(i) for i in input().split()]
	s = input()
	p = [int(i) for i in input().split()]
	alphabet = "abcdefghijklmnopqrstuvwxyz"
	p.sort()
	dic = {i:0 for i in alphabet}
	lst = [0 for i in range(n)]
	# p = [1,3,3,4,6] # i
	# s = abcdabghj # j
	j=0 # 
	i=0 #
	while 1:
		if i>=m or j>=n:
			break
		if j<p[i]:
			lst[j]=m-i 
			j+=1 
		elif j>=p[i]:
			i+=1
	for i in range(n):
		dic[s[i]]+=lst[i]
		dic[s[i]]+=1
	for i in dic:
		print(dic[i],end=" ")
	print()





