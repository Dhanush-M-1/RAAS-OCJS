t = int(input())
for _ in range(t):
    n = int(input())
    last = [0, 0]
    output = "YES"
    for i in range(n):
        p ,c = map(int, input().split())
        if output == "YES":
            if p < c:
                output = "NO"
                continue
            if p < last[0]:
                output = "NO"
                continue
            if c < last[1]:
                output = "NO"
                continue
            if p - last[0] < c - last[1]:
                output = "NO"
                continue
            last = [p, c]

    print(output)