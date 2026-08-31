n,k  = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

ans = 100000

for t in a:
    if k%t == 0 and k//t < ans: ans = k//t

print(ans)
