N = int(input())
B = []
for i in range(0, N):
    a, b, c = map(int, input().split())
    if c < a or c > b:
        B.append(c)
    else:
        B.append((b // c + 1) * c)
for i in B:
    print(i)
