def MinimumInteger(l,r,d):
	if d<l:
		return d%l
	else:
		return r+(d-(r%d))

q = int(input())
result = ''
while q>0:
	l,r,d = [int(x) for x in input().split()]
	result+=str(MinimumInteger(l,r,d))
	if q>1:
		result+='\n'
	q-=1

print(result)