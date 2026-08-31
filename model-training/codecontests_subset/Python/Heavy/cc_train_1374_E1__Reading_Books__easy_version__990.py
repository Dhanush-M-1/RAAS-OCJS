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
# import math

# for _ in range(int(input())):
n,k1 = map(int,input().split())
c = []
a = []
b = []
for i in range(n):
	x,y,z = map(int,input().split())
	if y==z==1:
		c.append(x)
	elif y==1 and z==0:
		a.append(x)
	elif y==0 and z==1:
		b.append(x)
a.sort()
b.sort()
c.sort()
# print(a,b,c)
ka = k1
kb = k1
i,j,k = 0,0,0
ans = 0
while ka>0 and kb>0 and i<len(a) and j<len(b) and k<len(c):
	if a[i]+b[j]<=c[k]:
		ans += a[i]+b[j]
		ka-=1
		kb-=1
		i+=1
		j+=1
	else:
		ans += c[k]
		ka-=1
		kb-=1
		k+=1
if i>=len(a) and ka>0:
	while k<len(c) and ka>0:
		ans+=c[k]
		k+=1
		ka-=1
		kb = max(0,kb-1)
elif j>=len(b) and kb>0:
	while k<len(c) and kb>0:
		ans+=c[k]
		k+=1
		ka = max(0,ka-1)
		kb-=1
while i<len(a) and ka>0:
	ans += a[i]
	ka-=1
	i+=1
while j<len(b) and kb>0:
	ans+=b[j]
	kb-=1
	j+=1

if ka==kb==0:
	print(ans)
else:
	print(-1)







