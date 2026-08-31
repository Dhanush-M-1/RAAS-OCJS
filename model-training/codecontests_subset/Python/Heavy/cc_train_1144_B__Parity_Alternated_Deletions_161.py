from sys import stdin,stdout
from collections import Counter
def ai(): return list(map(int, stdin.readline().split()))
def ei(): return map(int, stdin.readline().split())
def ip(): return  int(stdin.readline().strip())
def op(ans): return stdout.write(str(ans) + '\n')

n=ip()
li = ai()
ans = sum(li)
even = []
odd = []
for i in range(n):
	if li[i]&1:
		odd.append(li[i])
	else:
		even.append(li[i])
even.sort(reverse=True)
odd.sort(reverse=True)
k = min(len(even),len(odd))
for i in range(k):
	ans-=(odd[i])
for i in range(k):
	ans -= even[i]
if len(even)>k:
	ans -= even[k]
if len(odd)>k:
	ans -= odd[k]
op(ans)
