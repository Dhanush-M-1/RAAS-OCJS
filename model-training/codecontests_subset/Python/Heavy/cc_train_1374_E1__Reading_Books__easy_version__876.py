def solve():
    n, k = list(map(int, input().split()))
    a = []
    b = []
    both = []
    alice = 0
    bob = 0
    coincidence = 0

    for i in range(n):
        t, a_, b_ = list(map(int, input().split()))
        if b_ and a_:
            both.append(t)
            coincidence += 1
        elif a_ == 1:
            a.append(t)
            alice += 1
        elif b_ == 1:
            b.append(t)
            bob += 1

    if alice + coincidence < k or bob + coincidence < k:
        print(-1)
    else:
        a.sort()
        b.sort()
        
        for i in range(min(len(a), len(b))):
            both.append(a[i]+b[i])
        
        both.sort()
        out = sum(both[:k])
        print(out)
        

cases = 1
for test in range(cases):
    solve()