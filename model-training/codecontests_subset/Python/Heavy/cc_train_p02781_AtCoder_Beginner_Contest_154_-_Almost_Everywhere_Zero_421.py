N = input()
K = int(input())

def K1(num):
	return int(num[0]) + (len(num)-1)*9

def K2(num):
	L = len(num)
	tmp = str(int(num[1:]))
	out = K1(tmp)
	out1 = (int(num[0])-1)*(L-1)*9
	out2 = ((L-1)*(L-2)//2)*9*9
	return out + out1 + out2

def K3(num):
	L = len(num)
	tmp = str(int(num[1:]))
	out = K2(tmp)
	out1 = (int(num[0])-1)*((L-1)*(L-2)//2)*9*9
	out2 = ((L-1)*(L-2)*(L-3)//6)*9*9*9
	return out + out1 + out2

if len(N) < K:
	ans = 0
else:
	if K == 1:
		ans = K1(N)
	elif K==2:
		ans = K2(N)
	else:
		ans = K3(N)

print(ans)