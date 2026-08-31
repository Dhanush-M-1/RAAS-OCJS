t = int(input())
for _ in range(t):
    n = int(input())
    lastp, lastc = 0, 0
    output = "YES"
    for i in range(n):
        p ,c = map(int, input().split())
        if output == "YES":
            if p < c:
                output = "NO"
                continue
            if p < lastp:
                output = "NO"
                continue
            if c < lastc:
                output = "NO"
                continue
            if p - lastp < c - lastc:
                output = "NO"
                continue
            lastp, lastc = p, c

    print(output)