#input template
from sys import stdin, stdout
cin = stdin.readline
cout = stdout.write
mp = lambda: list(map(int, cin().split()))

def chars(): #function for taking string input as character array since string in python is immutable
    s = cin()
    return(list(s[:len(s) - 1]))

#print list	
def pl(a):	
	for val in a:
		cout(str(val) + ' ')
	cout('\n')
		
#main

t, = mp()
for _ in range(t):
	n, = mp()
	a = mp()
	
	maxi = -10**9
	mini = 10**9
	
	for i in range(n):
		if a[i] != -1:
			if i > 0 and a[i-1] == -1:
				mini = min(mini, a[i])
				maxi = max(maxi, a[i])
			elif i < n-1 and a[i+1] == -1:
				maxi = max(maxi, a[i])
				mini = min(mini, a[i])
	m = 0
	k = (maxi + mini)//2
	for i in range(n):
		if a[i] == -1:
			a[i] = k
		if i:
			m = max(m, abs(a[i]-a[i-1]))
	pl([m, k])
		 	   	      	     		  	  	  	