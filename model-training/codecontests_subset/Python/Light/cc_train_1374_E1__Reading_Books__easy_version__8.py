nb_books, mins = [int(x) for x in input().split()]
x, y, z = [],[],[]
for i in range(nb_books):
    n, a, b = [int(x) for x in input().split()]
    if a & b:z.append(n)
    elif a:x.append(n)
    elif b:y.append(n)
x.sort()
y.sort()

for i in range(min(len(x), len(y)))    :
    z.append(x[i] + y[i])
answer = sum(sorted(z)[:mins])


print(-1 if len(z) < mins else answer)
