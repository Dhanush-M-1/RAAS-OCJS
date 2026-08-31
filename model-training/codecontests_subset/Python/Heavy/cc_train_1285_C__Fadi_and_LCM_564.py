#Import libraries here.
import math

def intinputlist():    #Take input in one line as list of int
	l = [int(x) for x in input().split()]
	return l

def printlist(l):    #Prints list in a single line with spaces
	print(*l)

def power(x,y,p):     #Calculates (x**y)%p in O(log y)
    res = 1
    x = x%p

    while y>0:
        if ((y & 1)==1):
            res = (res*x)%p

        y = y>>1
        x = (x*x)%p

    return res


def gcd(a,b):        #Calculates gcd of a and b
    if a==0:
        return b
    return gcd(b%a,a)

def lcm(a,b):       #Calculates lcm of a and b
    return (a*b)/gcd(a,b)

def divisorsof(n):
    l = []
    i = 1
    while i<=math.sqrt(n):
        if (n%i==0):
            if (n/i == i):
                l.append(i)
            else:
                l.append(i)
                l.append(n/i)

        i = i+1
    return l

#main

x = int(input())
div = divisorsof(x)

d1 = x
d2 = 1

for  i in range(len(div)):
    if lcm(div[i],x/div[i]) == x and max(div[i],x/div[i])<max(d1,d2):
        d1 = div[i]
        d2 = x/div[i]

print(int(d1),int(d2))