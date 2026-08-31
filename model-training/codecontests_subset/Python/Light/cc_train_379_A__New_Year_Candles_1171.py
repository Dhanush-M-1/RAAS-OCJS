t, k = [ int(x) for x in input().split(' ') ]

def f(a, b) :
	if not a :
		return 0

	return a + f( (a+b)//k, (a+b)%k )

print(f(t,0))
