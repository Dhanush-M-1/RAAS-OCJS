# from debug import debug
import sys;input = sys.stdin.readline

n, k = map(int, input().split())
s1, s2, s3 = [], [], []
for i in range(n):
	a, b, c = map(int, input().split())
	if b == c == 1: s1.append(a)
	elif b == 1: s2.append(a)
	elif c == 1: s3.append(a)
s1.sort(); s2.sort(); s3.sort();
i, j, l = 0, 0, 0
days = 0
likes = 0
n1, n2, n3 = len(s1), len(s2), len(s3)
while likes < k:
	if i == n1:
		if j == n2 or l == n3: break
		likes += 1
		days += s2[j]+s3[l]
		j+=1; l+=1
	elif j == n2:
		if i == n1: break
		likes += 1
		days += s1[i]
		i+=1
	elif l == n3:
		if i == n1: break
		likes+=1
		days+=s1[i]
		i+=1
	else:
		if s1[i] >= s2[j]+s3[l]:
			days += s2[j]+s3[l]
			j+=1; l+=1
			likes += 1
		else:
			days += s1[i]
			i+=1
			likes += 1
	if i == n1 and j == n2 and l == n3: break

if likes<k: print(-1)
else: print(days)

