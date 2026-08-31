# http://codeforces.com/problemset/problem/915/A

def solve(n,k,A):
	for a in reversed(sorted(A)):
		if(k%a==0):
			return int(k/a)
	return -1

n = [int(i) for i in input().split()]
k = n[1]
n = n[0]
A = [int(i) for i in input().split()]

print(solve(n,k,A))

