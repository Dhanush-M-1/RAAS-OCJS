n = int(input())
nar = list(map(int, input().split()))
m = int(input())

for q in range(m):
    k, p = list(map(int, input().split()))
    mar = []
    for i in range(k):
        mar.append(nar[i])
    for i in range(k, n):
        minItem = 0
        for j in range(1, k):
            if mar[j] <= mar[minItem]:
                minItem = j
        if nar[i] > mar[minItem]:
            mar.pop(minItem)
            mar.append(nar[i])
    print(mar[p-1])