import sys
import re
from collections import defaultdict


s = input()

x = re.finditer('(?=([0-9]{2}-[0-9]{2}-[0-9]{4}))', s)
x = [match.group(1) for match in x]

d = defaultdict(int)

for i in x:
	l = i.split('-')
	if(int(l[2]) >= 2013 and int(l[2]) <= 2015):
		if int(l[1]) in [1, 3, 5, 7, 8, 10, 12]:
			if int(l[0]) > 0 and int(l[0]) < 32:
				d[i] = d[i] + 1
		elif int(l[1]) in [4, 6, 9, 11]:
			if int(l[0]) > 0 and int(l[0]) < 31:
				d[i] = d[i] + 1
		elif(int(l[1]) == 2):
			if int(l[0]) > 0 and int(l[0]) < 29:
				d[i] = d[i] + 1


k = 0
m = 0
for i, j in d.items():
	if j > k: 
		m = i
		k = j
	

print(m)
