n = int(input())
for x in range(n):
    l, r, d = map(int, input().split())
    q = l // d
    q1 = r // d
    if q > 0:
        if q == 1 and l % d == 0:
            pass
        else:
            if d < l:
                print(d)
            else:
                print((q) * d)
            continue
    print((q1 + 1) * d)

            
        
