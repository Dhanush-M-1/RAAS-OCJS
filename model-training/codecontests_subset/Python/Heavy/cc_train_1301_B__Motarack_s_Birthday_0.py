# import sys
# file = open('test1')
# sys.stdin = file
def ii(): return int(input())
def ai(): return list(map(int, input().split()))
def mi(): return map(int, input().split())

for _ in range(int(input())):
	n = ii()
	lst = ai()
	nlst = []
	for ind, ele in enumerate(lst):
		if ele==-1:
			if ind!=0 and lst[ind-1]!=-1:  nlst.append(lst[ind-1])
			if ind!=n-1 and lst[ind+1]!=-1: nlst.append(lst[ind+1])
	if len(nlst)!=0:
		mx,mn = max(nlst), min(nlst)
		k = (mx+mn)//2
		nlst = [k if i==-1 else i for i in lst]
		m = 0
		for i in range(1,n):
			m = max(m, abs(nlst[i]-nlst[i-1]))
		print(m, k)
	else: print(0, 1)
