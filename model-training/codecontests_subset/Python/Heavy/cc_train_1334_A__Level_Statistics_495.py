import sys
try:
    sys.stdin = open('input.txt', 'r') 
    sys.stdout = open('output.txt', 'w')
except:
    pass
t = int(input())
for _ in range(t):
	n  = int(input())
	prev_a = 0
	prev_b = 0
	flag = True
	l = []

	for i in range(n):
		a,b = map(int,input().split())
		l.append([a,b])
	# print(l)

	for a,b in l:
		if a<prev_b or b<prev_b:
			# print(prev_a,prev_b,a,b,"*")
			flag = False
			break
		if (a-prev_a) < (b-prev_b):
			# print(prev_a,prev_b,a,b)
			flag = False
			break
		prev_a = a; prev_b = b
	if flag:
		print("YES")
	else:
		print("NO")
	
