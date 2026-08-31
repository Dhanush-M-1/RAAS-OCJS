n=int(input())
d=dict()
a=["AC","WA","TLE","RE"]
for x in a:
	d[x]=0
for _ in range(n):
	d[input()]+=1
for x in a:
	print(x + " x " + str(d[x]))