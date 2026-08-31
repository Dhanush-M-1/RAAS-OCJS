def makeCntMap(A):
	cnt={}
	for item in A:
		if item in cnt:
			cnt[item]+=1
		else:
			cnt[item]=1
	return cnt

n,m=map(int,input().split())
A=sorted([int(x)%m for x in input().split()])
B=sorted([int(x)%m for x in input().split()])

cntA=makeCntMap(A)
cntB=makeCntMap(B)

minGuy=list(cntA.keys())[0]
for item in cntA:
	if cntA[item] < cntA[minGuy]:
		minGuy=item
cands=[]
for item in cntB:
	if cntB[item]==cntA[minGuy]:
		cands.append(item+m)

ans=m-1

for item in cands:
	x=(item-minGuy)%m
	arr=sorted([(temp+x)%m for temp in A])
	if arr==B:
		ans=min(ans,x)
print(ans)
