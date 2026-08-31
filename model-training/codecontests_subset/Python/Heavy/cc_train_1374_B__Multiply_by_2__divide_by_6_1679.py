# for _ in range(int(input())):
# 	n,x = map(int,input().split())
# 	arr = list(map(int,input().split()))
# 	# b = []
# 	# for i in range(n):
# 	# 	t = []
# 	# 	for j in range(n):
# 	# 		t.append(arr[i]+arr[j])
# 	# 	b.append(t)
# 	f = 0
# 	k = n
# 	while k>=1:
# 		# print(k)
# 		i = 0
# 		while i<k:
# 			# print(i)
# 			j = i
# 				print(k,i,j)
# 				print(arr[i:i+k+1], arr[j:j+k+1])
# 				s = k*(sum(arr[i:i+k+1]) + sum(arr[j:j+k+1]))
# 				# print(s)
# 				if s==x:
# 					f+=1
# 		k-=1
# 	print(f)
# print(1000000000//499999993 , 1000000000%499999993)
# print(999999995//499999993 , 999999995%499999993)
import math
for _ in range(int(input())):
	n = int(input())
	if n==1:
		print(0)
	else:
		r = {2:0,3:0}
		while n%2==0:
			r[2]+=1
			n = n//2
		while n%3==0:
			r[3]+=1
			n = n//3
		if n!=1:
			print(-1)
		else:
			if r[2]>r[3]:
				print(-1)
			elif r[2]==r[3]:
				print(r[2])
			else:
				print(r[3]-r[2] + r[3])









