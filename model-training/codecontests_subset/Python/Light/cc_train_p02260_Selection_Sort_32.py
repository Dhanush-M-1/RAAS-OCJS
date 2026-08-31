n = int(input())
cards = list(map(int,input().split()))
cnt = 0
for i in range(n):
    minj = i
    for j in range(i,n):
        if cards[minj] > cards[j]:
            minj = j
    if i != minj:
        cnt += 1
    cards[i], cards[minj] = cards[minj], cards[i]


print(*cards)
print(cnt)

