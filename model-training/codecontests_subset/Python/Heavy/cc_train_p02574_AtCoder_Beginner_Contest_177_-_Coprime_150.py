n = int(input())
a = list(map(int, input().split()))
li = [0] * 1100000
is_prime = [True] * 1100000
is_prime[0] = is_prime[1] = False
for i in a:
    li[i] += 1
is_pairwise = True
for i in range(2, 1100000):
    if is_prime[i]:
        cnt = 0
        for j in range(i, 1100000, i):
            is_prime[j] = False
            cnt += li[j]
        if cnt == n:
            print("not coprime")
            exit()
        if cnt > 1:
            is_pairwise = False
if is_pairwise:
    print("pairwise coprime")
else:
    print("setwise coprime")