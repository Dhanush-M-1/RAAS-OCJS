from collections import Counter as C
n=int(input())
a=C(list(input().split()))
b=C(list(input().split()))
c=C(list(input().split()))
for i in a:
	if i not in b:
		print(i)
		break
	if b[i]!=a[i]:
		print(i)
		break
for i in b:
	if i not in c:
		print(i)
		break
	if c[i]!=b[i]:
		print(i)
		break