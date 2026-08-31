import sys
import functools

[n,k]=[int(i) for i in sys.stdin.readline().split()]

arr=[]

for x in range(n):
	[t,a,b]=[int(j) for j in sys.stdin.readline().split()]
	arr.append([t,a,b])

alice=0
bob=0
for g in range(n):
	if(arr[g][1]==1):
		alice+=1
	if(arr[g][2]==1):
		bob+=1

if(alice<k or bob<k):
	print(-1)
else:

	comb_arr=[]
	f_arr=[]
	s_arr=[]

	for p in range(n):
		if(arr[p][1]==1 and arr[p][2]==1):
			comb_arr.append(arr[p][0])
		elif(arr[p][1]==1):
			f_arr.append(arr[p][0])
		elif(arr[p][2]==1):
			s_arr.append(arr[p][0])

	f_arr.sort()
	s_arr.sort()

	for c in range(min(len(f_arr),len(s_arr))):
		comb_arr.append(f_arr[c]+s_arr[c])

	comb_arr.sort()
	ans=sum(comb_arr[:k])

	print(ans)

	# a_arr=[]
	# b_arr=[]
	# for a in range(n):
	# 	if(arr[a][1]==1):
	# 		a_arr.append([arr[a][0],arr[a][1],arr[a][2],a])
	# 	if(arr[a][2]==1):
	# 		b_arr.append([arr[a][0],arr[a][1],arr[a][2],a])

	# a_arr.sort()
	# b_arr.sort()

	# # alice first
	# ax=0

	# ans1=0
	# d1={}
	# for g in range(k):
	# 	if(a_arr[g][2]==1):
	# 		ax+=1
	# 		d1[a_arr[g][3]]=1
	# 	ans1+=a_arr[g][0]

	# c1=0
	# i1=0
	# while(c1<k-ax):
	# 	if(b_arr[i1][3] not in d1):
	# 		ans1+=b_arr[i1][0]
	# 		c1+=1

	# 	i1+=1

	# # bob first
	# bx=0

	# ans2=0
	# d2={}
	# for h in range(k):
	# 	if(b_arr[h][1]==1):
	# 		bx+=1
	# 		d2[b_arr[h][3]]=1
	# 	ans2+=b_arr[h][0]

	# c2=0
	# i2=0
	# while(c2<k-bx):
	# 	if(a_arr[i2][3] not in d2):
	# 		ans2+=a_arr[i2][0]
	# 		c2+=1

	# 	i2+=1

	# ans=min(ans1,ans2)
	# print(ans)

