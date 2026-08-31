n = int(input())
a = list(map(int, input().split()))

trade = 0
for i in range(n):
    minj = i 
    for j in range(i, n):
        if a[j] < a[minj]:
            minj = j
    if i != minj:
        trade += 1
    a[i], a[minj] = a[minj], a[i]
    
print(' '.join(map(str, a)))
print(trade)
