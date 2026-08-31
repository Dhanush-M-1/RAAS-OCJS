from sys import stdin,stdout
from collections import Counter
def ai(): return list(map(int, stdin.readline().split()))
def ei(): return map(int, stdin.readline().split())
def ip(): return  int(stdin.readline().strip())
def op(ans): return stdout.write(str(ans) + '\n')

n=ip()
li = ai()
even = []
odd = []
for i in range(n):
	if li[i]&1:
		odd.append(li[i])
	else:
		even.append(li[i])
even.sort(reverse=True)
odd.sort(reverse=True)
while len(odd)>0 and len(even)>0:
	odd.pop(0);even.pop(0)
ans = 0
if len(odd)==len(even):
	ans = 0
elif len(odd)>len(even):
	ans=odd[0]
else:
	ans = even[0]
print((sum(even)+sum(odd))-ans)

	