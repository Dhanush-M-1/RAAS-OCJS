T = int(input())
query = [list(map(int, input().split())) for i in range(T)]

def gcd(a, b):
	while b:
		a, b = b, a % b
	return a


ans_list = []
for i in range(T):
    A = query[i][0]
    B = query[i][1]
    C = query[i][2]
    D = query[i][3]
    if A < B:
        ans_list.append("No")
        continue
    if B > D:
        ans_list.append("No")
        continue
    if C >= B:
        ans_list.append("Yes")
        continue
    g = gcd(B, D)
    max_modB = B - g + A%g
    if max_modB > C:
        ans_list.append("No")
    else:
        ans_list.append("Yes")
        

print('\n'.join(ans_list))