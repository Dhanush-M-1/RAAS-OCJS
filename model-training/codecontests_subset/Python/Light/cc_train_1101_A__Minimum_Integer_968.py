q = int(input())

for _ in range(q):
    l, r, d = [int(x) for x in input().strip().split()]

    if d < l:
        print(d)
    else:
        print( r//d * d + d)
        
