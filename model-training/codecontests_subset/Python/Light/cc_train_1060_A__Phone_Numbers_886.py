n = int(input())
s = input()

maxnum = n//11

eights = 0
for i in range(0,n):
	if s[i] == '8':
		eights += 1

if maxnum<eights:
	print(maxnum)
else:
	print(eights)