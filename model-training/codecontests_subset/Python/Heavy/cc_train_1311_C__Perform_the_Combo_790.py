# n,k = map(int,input().split())
# arr = []
# dic = set()
# for i in range(n):
# 	v = input()
# 	arr.append(v)
# 	dic.add(v)
# c = 0
# ans = set()
# s = 0
# # print(arr)
# for i in range(n-1):
# 	for j in range(i+1,n):
# 		x = ''
# 		for f in range(k):
# 			l = ['S','E','T']
# 			m = set(l)
# 			if arr[i][f]!=arr[j][f]:
# 				m.discard(arr[i][f])
# 				m.discard(arr[j][f])
# 				x+=list(m)[0]
# 			else:
# 				x+=arr[i][f]
# 		if x in dic:
# 			g = frozenset([arr[i],arr[j],x])
# 			if g not in ans:
# 				c+=1
# 				ans.add(g)

# # print(ans)
# print(c)

# n,p,k = map(int,input().split())
# arr = list(map(int,input().split()))
# arr.sort()

# print(c)

# arr = [1,3,6,5]
# print(1 in arr)

# from math import gcd,sqrt
# for _ in range(int(input())):
# 	a,b = map(int,input().split())
# 	if a==b:
# 		print(-1)
# 	else:
# 		n = a
# 		m = b
# 		# print(a*b//gcd(a,b))
# 		a-=1
# 		b-=1
# 		ans = 0
# 		g = []
# 		for i in range(1,max(a,b)+1):
# 			if a%i==b%i:
# 				g.append(i)
# 				ans+=1
# 		print(ans)
# 		# print(ans)
# 		# print(g)
# 		# ans = 0
# 		# m -= n
# 		# while m>1:
# 		# 	ans+=1
# 		# 	m = m//2
# 		h = []
# 		ans2 = 0
# 		a =  min(n-1,m-1)
# 		b = max(n-1,m-1)
# 		print(a,b)
# 		for i in range(1,a+1):
# 			if a%i==b%i:
# 				h.append(i)
# 				ans2+=1
# 		# v = b-a
# 		v = b-a
# 		i = 1
# 		for i in range(a+1,int(sqrt(v))+1):
# 			if v%i==0:
# 				if n//i == i:
# 					ans2+=1
# 					h.append(i)
# 				else:
# 					ans2+=2
# 					h.append(i)
# 					h.append(n//i)
# 		# while i <= sqrt(v): 
# 		#     if (v% i == 0) : 
# 		#         if (v// i == i) : 
# 		#         	h.append(i)
# 		#             ans2+=1
# 		#         else : 
# 		#             ans2+=2
# 		#     i = i + 1
# 		print(ans2)
# 		h.sort()
# 		print(g,h)



for _ in range(int(input())):
	n,m = map(int,input().split())
	s = input()
	arr = [[0]*(n+1) for i in range(26)]
	ans = [0]*26
	p = list( map(int,input().split()))
	for i in range(n):
		v = ord(s[i])-97
		arr[v][i+1] = 1
	for i in range(26):
		for j in range(1,n+1):
			arr[i][j] += arr[i][j-1]
	for i in p:
		for j in range(26):
			ans[j]+= arr[j][i]
	for j in range(26):
		ans[j]+= arr[j][n]
	print(*ans)







