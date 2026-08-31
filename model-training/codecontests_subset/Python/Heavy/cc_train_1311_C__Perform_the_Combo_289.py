import sys
input=sys.stdin.readline
LI=lambda :list(map(int, input().split()))
MI=lambda :map(int, input().split())
SI=lambda :input().strip('\n')
for _ in range(int(input())):
	n, m=MI()
	s=SI()
	a=sorted(map(lambda x:int(x)-1, input().split()))
	num=[1]*n
	for i in range(n):
		l=0; r=m-1
		ret=-1
		while l<=r:
			mid=(l+r)//2
			if a[mid]>=i:
				ret=mid
				r=mid-1
			else:
				l=mid+1
		if ret!=-1:
			num[i]=m-ret+1
	cnt={}
	for i in range(26):
		cnt[chr(i+ord('a'))]=0
	for i, c in enumerate(s):
		cnt[c]+=num[i]
	print(*(cnt.values()))