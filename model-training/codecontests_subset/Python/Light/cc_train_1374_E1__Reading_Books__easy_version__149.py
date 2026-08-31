n, k = map(int, input().split())

z11, z01, z10 = [], [], []

for i in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 1:
        z11.append(t)
    elif a == 1:
        z10.append(t)
    elif b == 1:
        z01.append(t)

i, j = min(k,len(z11)), min(k,len(z01),len(z10))

z11.sort()
z10.sort()
z01.sort()

if i + j < k:
    print(-1)
    exit()

while i + j > k:
    if z11[i-1] > z10[j-1] + z01[j-1]:
        i -= 1
    else:
        j -= 1

print(sum(z11[:i])+sum(z10[:j])+sum(z01[:j]))