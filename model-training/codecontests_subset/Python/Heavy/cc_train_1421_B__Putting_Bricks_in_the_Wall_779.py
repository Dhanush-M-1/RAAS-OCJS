t = int(input())
for x in range(t):
	n = int(input())
	s = [0]
	for i in range(n):
		s.append(' '+input())
	if s[1][2] == '0' and s[2][1] == '0':
		s1 = False
		if s[n-1][n] == '1':
			s1 = True
		s2 = False
		if s[n][n-1] == '1':
			s2 = True
		if s1 and s2:
			print(0)
		elif s1:
			print(1)
			print(n,n-1)
		elif s2:
			print(1)
			print(n-1,n)
		else:
			print(2)
			print(1,2)
			print(2,1)
		continue
	if s[1][2] == '1' and s[2][1] == '1':
		s1 = False
		if s[n-1][n] == '1':
			s1 = True
		s2 = False
		if s[n][n-1] == '1':
			s2 = True
		if s1 and s2:
			print(2)
			print(1,2)
			print(2,1)
		elif s1:
			print(1)
			print(n-1,n)
		elif s2:
			print(1)
			print(n,n-1)
		else:
			print(0)
		continue
	if s[1][2] == '1' and s[2][1] == '0':
		s1 = False
		if s[n-1][n] == '1':
			s1 = True
		s2 = False
		if s[n][n-1] == '1':
			s2 = True
		if s1 and s2:
			print(1)
			print(1,2)
		elif s1:
			print(2)
			print(1,2)
			print(n,n-1)
		elif s2:
			print(2)
			print(1,2)
			print(n-1,n)
		else:
			print(1)
			print(2,1)
		continue
	if s[1][2] == '0' and s[2][1] == '1':
		s1 = False
		if s[n-1][n] == '1':
			s1 = True
		s2 = False
		if s[n][n-1] == '1':
			s2 = True
		if s1 and s2:
			print(1)
			print(2,1)
		elif s1:
			print(2)
			print(1,2)
			print(n-1,n)
		elif s2:
			print(2)
			print(1,2)
			print(n,n-1)
		else:
			print(1)
			print(1,2)
		continue