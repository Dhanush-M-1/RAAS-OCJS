n,mo=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))

da={}
db={}

for i in range(len(a)):
	try:
		da[a[i]]+=1
	except:
		da[a[i]]=1

	try:
		db[b[i]]+=1
	except:
		db[b[i]]=1

cona={}
for i in da.keys():
	try:
		cona[da[i]].append(i)
	except:
		cona[da[i]]=[i]



conb={}
for i in db.keys():
	try:
		conb[db[i]].append(i)
	except:
		conb[db[i]]=[i]

def check(dif,k1,k2):
	for i in range(len(k1)):
		w=(k1[i]+dif)%mo
		if w not in k2:
			return False
	return True

# print(cona)
# print(conb)
l=[]
for key in cona.keys():
	l.append([len(cona[key]),key])
m=min(l)
k1=cona[m[1]]
k2=conb[m[1]]
# print(k1,k2)
num=k1[0]
for i in range(len(k2)):
	dif=k2[i]-num
	if dif<0:
		dif+=mo
	# print(dif)
	dif=dif%mo
	if check(dif,k1,k2):
		print(dif)
		break

