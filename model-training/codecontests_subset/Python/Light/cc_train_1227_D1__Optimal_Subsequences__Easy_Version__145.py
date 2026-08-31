n = int(input())
l = [int(j) for j in input().split()]
m = int(input())
d = dict()
for i in range(n):
	if l[i] in d:
		d[l[i]].append(i)
	else:
		d[l[i]]=[i]
d = sorted(d.items(), reverse =True)
# print(d)
for que in range(m):
	k, pos = [int(j) for j in input().split()]
	min_ = []
	i = 0
	j = 0
	while(k>0):
		k-=1
		min_.append(d[i][1][j])
		j+=1
		if j==len(d[i][1]):
			i+=1
			j = 0
	min_.sort()
	# print([l[x] for x in min_])
	print(l[min_[pos-1]])


