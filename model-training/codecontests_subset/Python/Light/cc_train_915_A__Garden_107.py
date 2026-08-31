n, k = map(int, input().split(' '))
i = map(int, input().split(' '))
max = 0
for j in i:
    if k % j == 0 and j > max:
        max = j
print( k // max)