from sys import stdin
input=lambda : stdin.readline().strip()

char = [chr(i) for i in range(97,123)]
CHAR = [chr(i) for i in range(65,91)]
mp = lambda:list(map(int,input().split()))
INT = lambda:int(input())
rn = lambda:range(INT())

from math import ceil,sqrt,factorial,gcd

n,k = mp()
alice = []
bob = []
common = []

for i in range(n):
	t,a,b = mp()
	if a==b==1:
		common.append(t)
	elif a==1:
		alice.append(t)
	elif b==1:
		bob.append(t)

if len(common + alice)<k or len(common + bob) < k:
	print(-1)
elif (len(alice)==0 or len(bob)==0) and len(common)>=k:
	common.sort()
	print(sum(common[:k]))
else:
	alice.sort()
	bob.sort()
	common.sort()

	inx = min(k,len(alice),len(bob))
	sma = sum(alice[:inx])
	smb = sum(bob[:inx])
	res = sma+smb

	if inx<k:
		res+=sum(common[:k-inx])

	common_inx = k-inx
	inx = inx

	res1 = res

	while common_inx < len(common) and inx>0:
		res -= alice[inx-1]
		res -= bob[inx-1]
		res += common[common_inx]
		res1 = min(res,res1)
		inx-=1
		common_inx+=1

	print(res1)

