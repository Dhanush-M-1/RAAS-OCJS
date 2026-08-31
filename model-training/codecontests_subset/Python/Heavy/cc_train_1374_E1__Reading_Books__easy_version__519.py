(n,k1) = map(int,input().split())


l_a,l_b,l_comb = [],[],[]
for _ in range(n):
	(ra,a,b) = map(int,input().split())
	if a==1 and b==1:
		l_comb.append(ra)
	elif a==1:
		l_a.append(ra)
	elif b==1:
		l_b.append(ra)
# print(l_comb,l_a,l_b)
if len(l_comb)+len(l_a) < k1 or len(l_comb)+len(l_b) < k1:
	print(-1)
else:
	l_comb.sort()
	l_a.sort()
	l_b.sort()
	ans = 0
	i,j,k = 0,0,0
	for _ in range(k1):
		if i<len(l_comb) and j<len(l_a) and k<len(l_b) and l_comb[i] < l_a[j]+l_b[k]:
			ans+=l_comb[i]
			i+=1 
		else:
			if j<len(l_a) and k<len(l_b):
				ans+=(l_a[j]+l_b[k])
				j+=1 
				k+=1 
			else:
				ans+=l_comb[i]
				i+=1
		# print(ans)
	print(ans)			
