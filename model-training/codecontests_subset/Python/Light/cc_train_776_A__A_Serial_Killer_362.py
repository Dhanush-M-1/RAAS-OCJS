n, m = map(str, input().split())
rang = []
rang.append([n, m])
days = int(input())
for i in range(days):
    r, g = map(str, input().split())
    if(n == r):
        n = g
    else:
        m = g
    rang.append([n, m])
for i in range(days + 1):
    print(" ".join(map(str, rang[i])))