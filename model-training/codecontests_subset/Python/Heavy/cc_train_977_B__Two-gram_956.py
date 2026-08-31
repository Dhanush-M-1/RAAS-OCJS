n = int(input())
s = input()

# d = {}
# maxs = ''
# maxn = 0
subs = []
for i in range(len(s) - 1):
	subs.append(s[i:i+2])

from collections import Counter

c = Counter(subs)

maxs = ''
maxn = 0
for i in c:
	if c[i] > maxn:
		maxn = c[i]
		maxs = i

print(maxs)

# d = {}
# for i in range(len(s) - 1):
# 	for j in range(i + 1, len(s)):
# 		 if s[i] + s[j] in subs:
# 		 	if s[i] + s[j] in d:
# 		 		d[s[i] + s[j]] += 1
# 		 	else:
# 		 		d[s[i] + s[j]] = 1
# 		 	if d[s[i] + s[j]] > maxn:
# 		 		maxn = d[s[i] + s[j]]
# 		 		maxs = s[i] + s[j]

# print(maxs)