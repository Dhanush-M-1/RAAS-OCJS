n , k = input().split()
n = int(n)
k = int(k)
c = []
a = []
b = []
for i in range(n):
	t,al,bo = input().split()
	if(al == '1' and bo == '1'):
		c.append(int(t))
	elif(al == '1'):
		a.append(int(t))
	elif(bo == '1'):
		b.append(int(t))

if(len(c)+len(a) < k or len(c)+len(b) < k):
	print(-1)
	quit()

c.sort()
a.sort()
b.sort()

for i in range(1,len(c)):
	c[i] = c[i] + c[i-1]

for i in range(1,len(a)):
	a[i] = a[i] + a[i-1]

for i in range(1,len(b)):
	b[i] = b[i] + b[i-1]

high = 2147483640
p = 0
tempo = 0
while(p <= len(c) and p<= k):
	if(p>0):
		tempo = c[p-1]
	else:
		tempo = 0
	dif = k-p
	if(len(a)>= dif and len(b)>=dif):
		if(dif > 0):
			tempo = tempo + (a[dif-1]+ b[dif-1])
		if(high >= tempo):
			high = tempo
	p = p + 1

print(high)
  	 		  				 	       	 			    	