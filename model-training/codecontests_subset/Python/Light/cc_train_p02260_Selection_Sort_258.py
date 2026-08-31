cnt, n, a = 0, int(input()), list(map(int, input().split()))
for i in range(n):
    mini = i
    for j in range(i, n):
        if a[j] < a[mini]: mini = j
    if i!=mini:
        a[i], a[mini] = a[mini], a[i]
        cnt+=1
print(*a)
print(cnt)