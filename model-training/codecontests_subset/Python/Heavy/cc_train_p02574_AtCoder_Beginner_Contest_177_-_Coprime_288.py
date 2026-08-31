import sys
def I(): return int(sys.stdin.readline().rstrip())
def LI(): return list(map(int,sys.stdin.readline().rstrip().split()))  #空白あり


N = I()
A = LI()


from math import gcd

g = 0  # Aiたちの最大公約数
for i in range(N):
    g = gcd(g,A[i])

if g != 1:
    print('not coprime')
    exit()


B = [0]*(10**6+1)
for i in range(N):
    B[A[i]] += 1

for d in range(2,5*10**5+1):
    a = sum(B[i] for i in range(d,10**6+1,d))
    if a >= 2:
        print('setwise coprime')
        break
else:
    print('pairwise coprime')

# 計算量 O(A*logA)
# A = max(Ai)
