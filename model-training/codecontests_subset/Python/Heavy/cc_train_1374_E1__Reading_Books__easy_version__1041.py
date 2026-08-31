# reading_books.py
from collections import defaultdict
n,k = map(int,input().split())
my_dick = {}
my_dick = defaultdict(lambda:list(),my_dick)
for i in range(n):
	a,b,c = map(int,input().split())
	if b+c==2:
		my_dick[b+c].append(a)
	elif b==0 and c == 1:
		my_dick[b+3].append(a)
	elif c==0 and b == 1:
		my_dick[c+4].append(a)

# if len(my_dick[2])>=k:
my_dick[2] = sorted(my_dick[2])
my_dick[3].sort()
my_dick[4].sort()
i = 0
while len(my_dick[3])>0 and len(my_dick[4])>0:
	my_dick[2].append(my_dick[3][i]+my_dick[4][i])
	my_dick[3].remove(my_dick[3][i])
	my_dick[4].remove(my_dick[4][i])

my_dick[2].sort()
if len(my_dick[2])>=k:
	print(sum(my_dick[2][:k]))
else:
	print("-1")