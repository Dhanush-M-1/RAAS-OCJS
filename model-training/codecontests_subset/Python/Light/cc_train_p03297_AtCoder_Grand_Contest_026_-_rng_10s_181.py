T = int(input())
    
def gcd(a, b):
	while b:
		a, b = b, a % b
	return a

for _ in range(T):
    A, B, C, D = map(int, input().split())
    #print("----", _, A, B, C, D)
    if A < B:
        print("No")
        continue
    
    if C < A%B < B:
        print("No")
        continue
    
    if D % B == 0:
        print("Yes")
        continue
    
    if D < B:
        print("No")
        continue
    
    if C+(gcd(B,D)) < B:
        print("No")
        continue
    
    print("Yes")