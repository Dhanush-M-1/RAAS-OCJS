r1, r2 = map(int, input().split())

c1, c2 = map(int, input().split())

d1, d2 = map(int, input().split()) 
found = False
for a in range(1,10):
    for b in range(1,10):
        if b != a:
            for c in range(1,10):
                if c != b and c != a:
                    for d in range(1,10):
                        if d != a and d !=b and d !=c:
                            if r1 == a+b and r2 == c+d and c1 == a+c and c2 == b+d and d1 ==a+d and d2 == b+c:
                                print(a,b)
                                print(c,d)
                                found = True
                                break
if not found:
    print(-1)
    
