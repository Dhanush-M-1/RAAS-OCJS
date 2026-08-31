n = int(input())
l = list(map(int, input().split()))
z = []
max_z = 0

for i in range(n):
    z.append(min(l[i] - 1, 1000000 - l[i]))

    if z[i] > max_z:
        max_z = z[i]
        
print(max_z)
