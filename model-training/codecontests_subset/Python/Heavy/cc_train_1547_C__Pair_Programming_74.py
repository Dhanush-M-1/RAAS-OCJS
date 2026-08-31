import math
inp=int(input())

for _ in range(inp):
	input()
	k,n,m=map(int,input().split(" "))
	a=list(map(int,input().split(" ")))
	b=list(map(int,input().split(" ")))
	i=0
	j=0
	res=[]
	while i<len(a) and j<len(b):
		if a[i]<b[j]:
			res.append(a[i])
			i+=1
		else:
			res.append(b[j])
			j+=1
	while i<len(a):
		res.append(a[i])
		i+=1
	while j<len(b):
		res.append(b[j])
		j+=1
	flag=True
	for i in res:
		if i==0:
			k+=1
		else:
			if k<i:
				flag=False
				break
	if flag:
		print(*res)
	else:
		print(-1)

# from wrapt_timeout_decorator import *
# @timeout(2.5)
# def i():
# 	p=0

# try:
# 	i()
# except Exception:
# 	print("TLE")