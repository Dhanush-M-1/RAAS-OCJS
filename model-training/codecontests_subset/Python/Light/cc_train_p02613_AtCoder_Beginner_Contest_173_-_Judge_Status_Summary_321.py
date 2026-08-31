a = {'AC':0,'WA':0,'TLE':0,'RE':0}
n = int(input())
for i in range(n):
	s = input()
	a[s] += 1
for i in a:
	print(i + ' x ' + str(a[i]))
