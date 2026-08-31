# Bad Triangle

t = int(input())

for i in range(0,t):
	n = int(input()); a = [ ]*n
	a = [int(x) for x in input().split()]
	
	if a[0]+a[1] <= a[len(a)-1]:
		print(f"1 2 {len(a)}")
	else:
		print("-1")