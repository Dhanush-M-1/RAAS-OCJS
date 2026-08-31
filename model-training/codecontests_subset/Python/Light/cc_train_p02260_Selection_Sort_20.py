n = int(input())
a = [int(i) for i in input().split()]
sw = 0
for i in range(n):
    minj = i
    for j in range(i+1,n):
        if a[j] < a[minj]: minj = j
    if i != minj:
        a[i],a[minj] = a[minj],a[i]
        sw += 1
print(" ".join(map(str,a)))
print(sw)
