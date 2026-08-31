N, K = [int(x) for x in input().split()]
l = [int(x) for x in input().split()]
lk = [0] * (1000000)
for n in l:
	t = n
	while t != 0:
		lk[t] += 1
		t //= 2
lk[0] = 99999999
g = 0
mn = 9999999
for i in range(len(lk) - 1, -1, -1):
	if(lk[i] >= K):
		g = i;
		ed = []
		for n in l:
			if(n < g): ed.append(9999999)
			elif(n == g): ed.append(0)
			else:
				t = n
				c = 0
				while True:
					t //= 2
					c += 1
					if(t <= g):
						if(t == g): ed.append(c)
						else: ed.append(9999999)
						break
		ed.sort()
		mn = min(mn, sum(ed[:K]))
print(mn)
# ed = []
# for n in l:
# 	if(n < g): ed.append(9999999)
# 	elif(n == g): ed.append(0)
# 	else:
# 		t = n
# 		c = 0
# 		while True:
# 			t //= 2
# 			c += 1
# 			if(t <= g):
# 				if(t == g): ed.append(c)
# 				else: ed.append(9999999)
# 				break
# ed.sort()
# print(sum(ed[:K]))
