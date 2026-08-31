a,b = list(map(int,input().strip().split(' ')))

currc = a
rem = 0
ans = 0

while 1:
	ans += currc
	rem += currc
	currc = 0
	if rem >= b:
		currc += rem//b
		rem = rem % b
	else:
		break

print(ans)