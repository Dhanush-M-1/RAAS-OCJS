from collections import Counter

n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]

d = Counter(a)
e = Counter(b)
f = Counter(c)

g = list((d - e).elements())
h = list((e - f).elements())

print(g[0])
print(h[0])
   			  		  		   		  	 		 	  	