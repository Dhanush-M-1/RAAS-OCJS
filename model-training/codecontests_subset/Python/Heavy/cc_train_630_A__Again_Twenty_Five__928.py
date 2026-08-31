'''
a1, a2, a3, a4 = list(map(int, input().split()))
s = input()
zero = 0
for i in range(len(s)):
	if s[i] == '1':
		zero += a1
	elif s[i] == '2':
		zero += a2
	elif s[i] == '3':
		zero += a3
	else:
		zero += a4
print(zero)
'''
'''
n = int(input())
a = list(map(int, input().split()))
for i in range(n):
	if a[i] % 2 == 0:
		a[i] = a[i] - 1
for i in a:
	print(i, end = " ")
print()
'''
'''
n = int(input())
lisofs = []
s = ''
for i in range(n):
	s = input()
	if 'OO' in s:
		lisofs.append('OO'.replace('OO', '++'))
		
for j in range(len(lisofs)):
	print(lisofs[j])
'''
n = int(input())
print(25)
