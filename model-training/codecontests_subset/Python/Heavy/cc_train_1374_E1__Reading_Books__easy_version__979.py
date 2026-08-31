# from mymodule import input
n,k = map(int, input().split())
li = [[list(),list()],[list(),list()]]
for i in range(n):
	a,b,c = map(int, input().split())
	li[b][c].append(a)
cnt = 0
itr1,itr2,itr3 = 0,0,0
li[0][1].sort()
li[1][0].sort()
li[1][1].sort()
ttl = 0
run = True
# print(li)
for i in range(k):
	sm = 0
	if itr1!=len(li[0][1]) and itr2!=len(li[1][0]):
		sm = li[0][1][itr1]+li[1][0][itr2]
		if itr3!=len(li[1][1]):
			if sm<li[1][1][itr3]:
				itr1+=1
				itr2+=1
				ttl+=sm
			else:
				ttl+=li[1][1][itr3]
				itr3+=1
		else:
			itr1+=1
			itr2+=1
			ttl+=sm
	elif itr3!=len(li[1][1]):
		ttl+=li[1][1][itr3]
		itr3+=1
	else:
		run = False
		break
if run:
	print(ttl)
else:
	print(-1)