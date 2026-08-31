from sys import stdin, stdout

for _ in range(int(stdin.readline())):
	n = int(stdin.readline())
	a = list(map(int, stdin.readline().split()))
	
	f = True; #k= 0
	for i in range(n):
		if a[i] >= i: continue;
		
		elif a[i] < i and f:
			f = False
			#k = i
			if a[i] == a[i-1]:
				a[i] -= 1
			if a[i] < n-1-i:
				stdout.write('No\n'); break;
		elif not f and a[i] >= n-1-i: continue;
			
		else:
			stdout.write('No\n')
			break
	else:
		stdout.write('Yes\n')
	
	'''
		elif a[i] == 0 and i < n-1:
			stdout.write('No\n'); break;
		elif a[i] == a[i-1] and a[i]-1 < n-1-i:
			stdout.write('No\n'); break;
		'''
	'''
	if 0 not in a:
		stdout.write('Yes\n')
	else:
		indices = [i for i, value in enumerate(a) if value == 0]
		
		if len(indices) < 2:
			stdout.write('Yes\n')
		elif len(indices) > 2:
			stdout.write('No\n')
		else:
			if indices[1] - indices[0] == 1:
				stdout.write('No\n')
			elif a[indices[1] - 1] >= indices[1] - indices[0] - 1 and 1 not in a[indices[0]+2 : indices[1]]:
				stdout.write('Yes\n')
			else:
				stdout.write('No\n')
	'''