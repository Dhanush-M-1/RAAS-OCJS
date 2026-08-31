t = int(input())

for i in range(t):
    n = int(input())
    p1 = None
    c1 = None
    for j in range(n):
        p, c = input().split()
        p, c = int(p), int(c)
        
        if p1 == None and c1 == None:
            p1, c1 = p, c

        if p1 >= c1 and p >= c:
            if p >= p1 and c >= c1 and (p - p1) >= (c - c1):
                ans = "YES"
                p1, c1 = p, c
            else:
                ans = "NO"
                break
        else:
            ans = "NO"
            break
        
    while j != n - 1:
        input().split()
        j = j + 1
    print(ans)
