
def gcd(a, b):
	while b:
		a, b = b, a % b
	return a


T = int(input())

for _ in range(T):
    A, B, C, D = map(int, input().split())
    if (A < B) or (D < B):
        print('No')
        continue
    elif (C+1 >= B):
        print('Yes')
        continue
    else:
        s_res = A % B
        s_k = int((C + 1 - s_res - 0.1) // B + 1)
        X = gcd(B, (D%B))
        if X == 1:
            print('No')
            continue
        else:
            s_0 = s_k * B + s_res
            if (s_0 - (C+1)) % X > (B-C-2):
                print('Yes')
            else:
                print('No')

