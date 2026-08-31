n = int(input())
l = list(map(int,input().split()))
r = sorted(l)
k = 0
def oddCount(l):
	if l%2 == 0:
		return False
	else:
		return True
def evenCount(l):
	if l%2 == 0:
		return True
	else:
		return False
# print(*r)
t1 = list(filter(oddCount,r))
t2 = list(filter(evenCount,r))
# print(*t1)
# print(*t2)
k = min(len(t1),len(t2))
if len(t1) == len(t2)+1 or len(t1)+1 == len(t2) or len(t1) == len(t2):
	print(0)
else:
	r = 0
	if k == len(t1):
		for i in range(len(t2)-k-1):
			r = r + t2[i]
	else:
		for j in range(len(t1)-k-1):
			r = r + t1[j]
	print(r)