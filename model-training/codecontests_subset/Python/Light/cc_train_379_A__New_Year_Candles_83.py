
line = input().split(" ")
a = int(line[0])
b = int(line[1])

c = a
cnt = 0
while c > 0:
	c -= 1
	cnt += 1
	if cnt % b == 0:
		c += 1



print(cnt)

