def solve(a):
    prev_pl, prev_cl = 0, 0
    for pl, cl in a:
        if pl < prev_pl or cl < prev_cl or cl > pl:
            return False
        elif cl - prev_cl > pl - prev_pl:
            return False 

        prev_pl = pl
        prev_cl = cl
    return True

t = int(input())

for _ in range(t):
    n = int(input())
    a = []
    for _ in range(n):
        pl, cl = map(int, input().split())
        a.append((pl, cl))
    
    if solve(a):
        print("YES")
    else:
        print("NO")
