from sys import stdin, stdout
cin = stdin.readline
cout = stdout.write
mp = lambda: list(map(int, cin().split()))

def chars(): #function for taking string input as character array since string in python is immutable
    s = cin()
    return(list(s[:len(s) - 1]))
	
def pl(a): #print list	
	for val in a:
		cout(str(val) + ' ')
	cout('\n')

t, = mp()
for _ in range(t):
	n, = mp()
	
	p = c = 0
	f = 0
	for i in range(n):
		x, y = mp()
		
		if x - p >= 0 and 0 <= y - c <= x-p :
			p = x
			c = y
		else:
			f = 1
	if f:
		cout('no\n')
	else:
		cout('yes\n')