lis = input().split()
n,k = int(lis[0]),int(lis[1])
like1 = []
like2 = []
likeall = []
for i in range(n):
	lis = input().split()
	tval,l1,l2 = int(lis[0]),int(lis[1]),int(lis[2])
	if(l1==1 and l2==1):
		likeall.append(tval)
	elif(l1==1):
		like1.append(tval)
	elif(l2==1):
		like2.append(tval)
like1.sort()
like2.sort()
likeall.sort()
if(len(like1)<len(like2)):
	mm = len(like1)
	like2 = like2[:len(like1)]
elif(len(like1)>len(like2)):
	mm = len(like2)
	like1 = like1[:len(like2)]
else:
	mm = len(like1)
if(mm+len(likeall)<k):
	print(-1)
else:
	likedouble = [0]*mm
	for i in range(mm):
		likedouble[i] = like1[i]+like2[i]
	merged = [0]*(mm+len(likeall))
	ind,ind1,ind2=0,0,0
	while(ind<k and ind1<mm and ind2<len(likeall)):
		if(likedouble[ind1]<likeall[ind2]):
			merged[ind] = likedouble[ind1]
			ind+=1
			ind1+=1
		else:
			merged[ind] = likeall[ind2]
			ind+=1
			ind2+=1
	while(ind<k and ind1<mm):
		merged[ind] = likedouble[ind1]
		ind+=1
		ind1+=1
	while(ind<k and ind2<len(likeall)):
		merged[ind] = likeall[ind2]
		ind+=1
		ind2+=1
	sum=0
	for i in range(k):
		sum+=merged[i]
	print(sum)