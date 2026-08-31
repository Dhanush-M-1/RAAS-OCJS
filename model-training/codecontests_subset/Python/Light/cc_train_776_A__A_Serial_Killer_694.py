line=input()
print(line)
now = line.split()
n=int(input())
for i in range(n):
	inp=input().strip()
	line=inp.split()
	for i in range(len(now)):
		if now[i]==line[0]:
			now[i]=line[1]
	for x in now:
		print(x,end=' ')
	print()


