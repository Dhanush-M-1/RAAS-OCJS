n=int(input())

def f(i, s, n):
	if i==n:
		print(s)
		return
	x=len(set(s))
	for j in range(x+1):
		f(i+1, s+chr(j+97), n)
		
f(0,"",n)
