# http://codeforces.com/contest/1060/problem/A

n=int(input())
lis=list(input())
n=len(lis)//11
c=lis.count('8')
if('8' in lis):
	print(min(n,c))
else:
	print(0)