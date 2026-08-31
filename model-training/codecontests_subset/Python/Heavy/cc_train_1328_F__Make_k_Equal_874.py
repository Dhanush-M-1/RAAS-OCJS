n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
a.sort(reverse=True)

val1 = k
val2 = k

lista = [0 for i in range(n)]

i=0
while i < n:
	j=0
	while(a[i]==a[i+j]):
		j = j+1
		if i+j==n:
			break
	lista[i] = j
	i = i+j

if max(lista)>=k:
	print(0)
	exit()

for i in range(n):
	if a[i]==a[k-1]:
		val1 = val1-1
		if val1==0:
			break
	elif a[i]>a[k-1]:
		val1 = val1+a[i]-a[k-1]-1

for i in range(n):
	if a[i]==a[n-k]:
		val2 = val2-1
		if val2==0:
			break
	elif a[i]<a[n-k]:
		val2 = val2+a[n-k]-1-a[i]

def fun(l,b,h):
	val34prov = h
	for i in range(len(b)):
		if b[i]==l:
			val34prov = val34prov-1
			if val34prov==0:
				return 0
		elif b[i]>l:
			val34prov = val34prov+b[i]-l-1
		else:
			val34prov = val34prov+l-1-b[i]
	return val34prov

if k<=n/2:
	print(min(val1,val2))
else:
	val3 = fun(a[n//2],a,k)
	if n%2==1:
		print(min(val1,val2,val3))
	else:
		val4 = fun(a[n//2-1],a,k)
		print(min(val1,val2,val3,val4))