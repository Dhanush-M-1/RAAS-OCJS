n, m = map(int, input().split())
B = []
for i in range(n):
    L = list(map(int, input().split()))
    for j in L[1:]:
        if j not in B:
            B += [j]
for i in range(1, m+1):
    if i not in B:
        print('NO')
        quit()
print('YES')
