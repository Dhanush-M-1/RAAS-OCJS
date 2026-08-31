# import math
# def pf(n):
# 	arr = []
# 	while n%2==0:
# 		arr.append(2)
# 		n//=2
# 	for i in range(3,int(math.sqrt(n))+1,2):
# 		while n%i==0:
# 			arr.append(i)
# 			n//=i
# 	if n>2:
# 		arr.append(n)
# 	return arr
# def lcm(a,b):
# 	return (a*b)//math.gcd(a,b)
# dic = {}
# # print(lcm(8*5,5*13))
# n = int(input())
# # n = 520
# aa = 0
# bb = 0
# minn = n
# arr = pf(n)
# m = set()
# for i in range(len(arr)):
# 	m.add(arr[i])
# 	try:
# 		dic[arr[i]]+=1
# 	except:
# 		dic[arr[i]] = 1
# m = list(m)
# print(dic)
# if len(dic)>1:
# 	a = 1
# 	for i in range(0,len(m)-1):
# 		a*=m[i]**dic[m[i]]
# 		b = 1
# 		for j in range(i+1,len(m)):
# 			b*=m[j]**dic[m[j]]
# 		print(a,b)
# 		if max(a,b)<minn:
# 			minn = min(minn,max(a,b))
# 			aa = a
# 			bb = b
# else:
# 	aa = 1
# 	bb = n
# print(min(aa,bb),max(aa,bb))
import math
def div(n):
	arr = []
	i = 1
	while i<=math.sqrt(n):
		if n%i==0:
			if n//i==i:
				arr.append(i)
			else:
				arr.append(i)
				arr.append(n//i)
		i+=1
	return arr
def lcm(a,b):
	return (a*b)//(math.gcd(a,b))
n = int(input())
arr = div(n)
minn = 10**13
a = 1
b = n
for i in range(len(arr)):
	if lcm(arr[i],n//arr[i])==n:
		if max(arr[i],n//arr[i])<minn:
			minn = min(max(arr[i],n//arr[i]),minn)
			a = arr[i]
			b = n//arr[i]
print(a,b)