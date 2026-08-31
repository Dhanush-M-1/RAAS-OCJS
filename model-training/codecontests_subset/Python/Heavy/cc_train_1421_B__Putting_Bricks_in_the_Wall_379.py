for _ in range(int(input())):
	n = int(input())
	arr = [list(input()) for i in range(n)]
	t = []
	s = [arr[0][1],arr[1][0]]
	f = [arr[-1][-2],arr[-2][-1]]
	if f[0]==f[1]:
		if f[0]=='0':
			if s[0]=='0':
				t.append([1,2])
			if s[1]=='0':
				t.append([2,1])
		else:
			if s[0]=='1':
				t.append([1,2])
			if s[1]=='1':
				t.append([2,1])
	else:
		if s[0]==s[1]:
			if s[0]=='0':
				if f[0]=='0':
					t.append([n,n-1])
				if f[1]=='0':
					t.append([n-1,n])
			if s[0]=='1':
				if f[0]=='1':
					t.append([n,n-1])
				if f[1]=='1':
					t.append([n-1,n])
		else:
			if s[0]=='1':
				t.append([1,2])
			elif s[1]=='1':
				t.append([2,1])
			if f[0]=='0':
				t.append([n,n-1])
			elif f[1]=='0':
				t.append([n-1,n])
	print(len(t))
	for i in t:
		print(*i)