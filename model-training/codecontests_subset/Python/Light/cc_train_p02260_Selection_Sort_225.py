n, *aa = map(int, open(0).read().split())

count = 0
for i in range(n):
    mini = i
    for j in range(i+1, n):
        if aa[j] < aa[mini]:
            mini = j
    if mini != i:
        aa[i], aa[mini] = aa[mini], aa[i]
        count += 1

print(*aa)
print(count)
