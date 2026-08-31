#input template
from sys import stdin, stdout
from collections import Counter, OrderedDict
import math
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

n, = mp()

mul = 1
sub = 1
for i in range(2, n+1):
	mul = (mul*i) % (10**9+7)
	sub = (sub*2) %(10**9+7)
	
ans = mul % (10**9+7) - sub % (10**9+7)

cout(str(ans%(10**9+7)))