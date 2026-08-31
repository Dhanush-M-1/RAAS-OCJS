def solve():
    n, l, r = [int(i) for i in input().split()]

    seq = []
    
    i = 1
    while l <= r:
        while l > 2 * n - 2:
            if l == 3:
                i = 1
                break
            l -= 2 * n - 2
            r -= 2 * n - 2
            n -= 1
            i += 1
       
        if l%2 == 0:
            seq.append(l // 2 + i)
        else:
            seq.append(i)
        
        l += 1
        
    return " ".join(str(i) for i in seq)

T = int(input())
for _ in range(T):
    print(solve())
