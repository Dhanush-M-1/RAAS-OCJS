# your code goes here
n = int(input())
s = input()
li = list(s)
c = li.count('1')
d = li.count('0')

if len(list(set(li))) == 1:
	print('1')
	print(s)
elif c==d:
	print('2')
	print(''.join(li[:1]),end = ' ')
	print(''.join(li[1:]))
elif c!=d:
	print('1')
	print(s)
else:
	q = 0
# else:
# 	if n%2!=0:
# 		# a = ''.join(li[:n//2])
# 		# b = ''.join(li[(n//2):])
# 		print('1')
# 		print(s)
# 	else:
# 		a = len(set(li[:n//2]))
# 		b = len(set(li[n//2:]))
# 		if a == 1 and b == 1:
# 			print('2')
# 			print(''.join(li[:n//2]),end = ' ')
# 			print(''.join(li[n//2:]))
# 		else:
# 			c = li.count('1')
# 			d = li.count('0')
# 			if c==d:
# 				print('2')
# 				print(''.join(li[:(n//2)]),end = ' ')
# 				print(''.join(li[(n//2):]))
# 			else:
# 				print('1')
# 				print(s)