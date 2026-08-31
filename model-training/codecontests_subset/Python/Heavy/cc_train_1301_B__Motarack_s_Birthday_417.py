import sys

input = sys.stdin.readline

def solve():
	n = int(input())
	al = list(map(int,input().split()))
	cop = al.copy()

	mx,mn = 0,max(al)
	ok = False

	for i in range(n):
		if al[i]!=-1:
			if (i>0 and al[i-1]==-1) or (i<n-1 and al[i+1]==-1):
				mx = max(mx,al[i])
				mn = min(mn,al[i])
				ok = True

	if ok==False:
		print(0,1)
		return
		
	k1 = (mx+mn)//2+1
	k2 = (mx+mn)//2

	for i in range(n): 
		if al[i]==-1: al[i] = k1
	for i in range(n):
		if cop[i]==-1: cop[i] = k2

	best = best2 = 0
	for i in range(n-1):
		best = max(best,abs(al[i]-al[i+1]))
	for i in range(n-1):
		best2 = max(best2,abs(cop[i]-cop[i+1]))

	print(best if best<best2 else best2, k1 if best<best2 else k2)

def main():
	t = int(input())
	for _ in range(t):
		solve()

main()