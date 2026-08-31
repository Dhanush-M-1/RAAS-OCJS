"""n = int(input())
count = 0
for i in range(n):
	c = 0
	p = [int(k) for k in input().split()]
	for j in p:
		if j == 1:
			c+=1
	if c >=2:
		count+=1
print(count)"""
"""n,k = input().split()
count = 0
scores = [int(i) for i in input().split()]
kth = scores[int(k)-1]
for j in scores:
	if j == 0:
		continue
	elif j>=kth:
		count += 1
print(count)"""
"""word = input()
vowel = ['a','e','i','o','u','y','A','E','I','O','U','Y']
for i in word:
	if i in vowel:
		continue
	elif i not in vowel:
		print('.'+i.lower(),end = '')"""
"""import math
m,n = input().split()
print(math.floor((int(m)*int(n))/2))"""
"""n = int(input())
x = 0
for i in range(n):
	lis = []
	lis = input()
	if (lis[0] == '+'and lis[1]=='+') or (lis[1] == '+' and lis[2] == '+'):
		x += 1
	elif (lis[0] == '-'and lis[1]=='-') or (lis[1] == '-' and lis[2] == '-'):
		x -= 1
print(x)"""
"""s = input()
a = s[0].capitalize()
print(a+s[1:])"""
"""Petya and strings
n1 = input()
n2 = input()
c = 0
for i in range(len(n1)):
	if ord(n1[i].lower()) > ord(n2[i].lower()):
		print(1)
		c = 1
		break
	elif ord(n1[i].lower()) < ord(n2[i].lower()):
		print(-1)
		c = 1
		break
	else:
		continue
if c == 0:
	print(0)"""
"""beautiful matrix
for i in range(5):
	a =[]
	for j in input().split():
		a.append(int(j))
	if 1 in a:
		print(abs(a.index(1)-2)+abs(i-2))"""
"""helpful maths"""
n = [int(i) for i in input().split('+')]
n.sort()
for i in range(len(n)):
	if i != len(n)-1:
		print(n[i],end='+')
	else:
		print(n[i])
 


