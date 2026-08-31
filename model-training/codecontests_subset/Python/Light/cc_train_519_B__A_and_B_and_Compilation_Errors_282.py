from collections import Counter
_=input()
a=Counter([int(i)for i in input().split()])
b=Counter([int(i)for i in input().split()])
c=Counter([int(i)for i in input().split()])
for k in a.keys():
	if a.get(k,0)!=b.get(k,0):
		print(k)
for k in b.keys():
	if b.get(k,0)!=c.get(k,0):
		print(k)