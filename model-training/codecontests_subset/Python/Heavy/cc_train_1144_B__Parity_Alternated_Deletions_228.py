import io, os
# input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
# input = io.StringIO(os.read(0, os.fstat(0).st_size).decode()).readline
kk=lambda:map(int,input().split())
k2=lambda:map(lambda x:int(x)-1, input().split())
ll=lambda:list(kk())
n, ls = int(input()), kk()
odd,even = [],[]
for l in ls:
	if l & 1: odd.append(l)
	else: even.append(l)
odd.sort()
even.sort()
l1, l2 = len(odd), len(even)
if max(l1,l2)-min(l1,l2) < 2:
	print(0)
else:
	if l1 > l2:
		print(sum(odd[:l1-l2-1]))
	else:
		print(sum(even[:l2-l1-1]))