import sys
import math

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

input = sys.stdin.readline

def gcd(a, b):
	if a == 0 or b == 0:
		return a + b
	if a > b:
		return gcd(a % b, b)
	else:
		return gcd(a, b % a)

def nsk(a, b):
	return a * b // gcd(a,b)

N = int(input())
A = list(map(int, input().split(' ')))
if N == 1:
	print(1, 1)
	print(0)
	print(1, 1)
	print(0)
	print(1, 1)
	print(-A[0])
	exit(0)

X = nsk(N, N-1)
# Step 1
print(1, N-1)
add = [(A[i] % N) * (N - 1) for i in range(N - 1)]
print(' '.join(map(str, add)))
for i in range(N - 1):
	A[i] += add[i]

# Step 2
print(N, N)
print(X - A[N - 1])
A[N - 1] = X

# Step 3
print(1, N)
print(' '.join(map(str, (-a for a in A))))

