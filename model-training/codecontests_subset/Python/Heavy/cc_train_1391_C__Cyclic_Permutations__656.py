# A = "b"
# B = ["aabbb"]
# dic = {}
# for i in B:
# 	dic[i] = 1
# ans = []
# def fun(start, n,ans, v, length):
# 	if length==n:
# 		ans+=[v[:-1]]
# 	for i in range(start, n):
# 		for j in range(start+1,n+1):
# 			try:
# 				if dic[A[i:j]]==1:
# 					fun(j,n,ans,v+A[i:j]+' ', length+len(A[i:j]))
# 			except:
# 				continue
# fun(0,len(A),ans, '', 0)
# ans.sort()


#Question 3
# arr = [1,1,2]
# n = int(input())
# ans = 1
# for i in range(1,n-1):
# 	x = n-i-1
# 	t = x*(x+1)//2
# 	if i-1>0:
# 		t*=(i-1)
# 	ans+= t%(10**9 +7)
# print(ans%(10**9 +7))
n = int(input())
f = 1
for i in range(2,n+1):
	f = f*i
	f%=(10**9 + 7)
p = pow(2,n-1,10**9 +7)
print((f-p)%(10**9 +7))