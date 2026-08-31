from sys import stdin, stdout
n=int(stdin.readline())

for i in range(n):
	arr=[]
	b=int(stdin.readline())
	for _ in range(b):
		arr.append(stdin.readline())
	count1s=(arr[0][1])+(arr[1][0])
	count2s=(arr[b-1][b-2])+(arr[b-2][b-1])
	noms=0
	cod=[]
	if count1s=='00':
		if count2s[0]=='0':
			noms+=1
			cod.append([b,b-1])
		if count2s[1]=='0':
			noms+=1
			cod.append([b-1,b])
	elif count1s=='11':
		if count2s[0]=='1':
			noms+=1
			cod.append([b,b-1])
		if count2s[1]=='1':
			noms+=1
			cod.append([b-1,b])
	elif count1s=='10':
		if count2s=='00':
			noms+=1
			cod.append([2,1])
		elif count2s=='01':
			noms=2
			cod.append([1,2])
			cod.append([b,b-1])
		elif count2s=='10':
			noms=2
			cod.append([1,2])
			cod.append([b-1,b])
		elif count2s=='11':
			noms=1
			cod.append([1,2])
	elif count1s=='01':
		if count2s=='00':
			noms+=1
			cod.append([1,2])
		elif count2s=='01':
			noms=2
			cod.append([1,2])
			cod.append([b-1,b])
		elif count2s=='10':
			noms=2
			cod.append([1,2])
			cod.append([b,b-1])
		elif count2s=='11':
			noms=1
			cod.append([2,1])
	print(noms)
	for i in cod:
		print("{} {}".format(i[0],i[1]))





	
