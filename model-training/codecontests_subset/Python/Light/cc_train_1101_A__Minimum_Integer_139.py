from math import *
#s=['toc','c++','c','cse',"lol",'c','c++']
#s.append("hi")
#s.insert(2,"ki")
#s.remove("toc")
#s.sort()
#s.reverse()
#s.pop()
#s2=s.copy()
#k=s.index('c')
#k=s.count('cse')
#k=list(range(1,n))
#print(n[2])
#print(s2)
n=int(input())
p=0
while p<n:
	a,b,c=input().split()
	a=int(a)
	b=int(b)
	c=int(c)
	if c<a:
		print(c)
	elif c>=a:
		k=b//c
		print((k+1)*c)
	p+=1 
'''
a={1,2,3,4,5}
b=set([4,5,6,7,8])
a.add(6)
if 4 in a:
	print('false')
print(a)
print(a|b)
print(a&b)
print(a-b)
'''
