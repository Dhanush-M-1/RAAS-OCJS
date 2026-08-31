t = int(input())
i = 0
while i < t:
    n, p, d = input().split()
    n = int(n)
    p = int(p)
    d = int(d)
    if n>d:
        print(d)
        i = i+1
        continue
    r = p//d
    print(d*(r+1))
    i = i + 1