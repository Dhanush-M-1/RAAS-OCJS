T = int(input())
def gcd(a,b):
	if a < b:
		a,b = b,a
	while b > 0:
		c = a % b
		a = b
		b = c
	return a

YES = 'Yes'
NO = 'No'
for i in range(T):
	A,B,C,D = map(int,input().split())
	if D < B or A < B:
		print(NO)
		continue
	D = D % B
	if C >= B:
		print(YES)
		continue
	rest = A % B
	if rest > C:
		print(NO)
		continue
	if D == 0:
		print(YES)
		continue
	g = gcd(B,D)
	left = C - rest
	right = B - rest
	n = left // g + 1
	if n * g < right:
		print(NO)
	else:
		print(YES)