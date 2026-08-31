n, k = map(int, input().split())
books = [list(map(int, input().split())) for _ in range(n)]
new_books = {str(i // 2) + str(i % 2): [0] for i in range(4)}
for book in books:
    new_books[str(book[1]) + str(book[2])].append(book[0])

for book in new_books.keys():
    new_books[book].sort()
    for i in range(1, len(new_books[book])):
        new_books[book][i] += new_books[book][i - 1]

ans = int(1e18)
for taken in range(k + 1):
    if len(new_books['11']) > taken and len(new_books['10']) > k - taken and len(new_books['01']) > k - taken:
        ans = min(ans, new_books['11'][taken]
                  + new_books['10'][k - taken]
                  + new_books['01'][k - taken])
print(ans if ans != int(1e18) else -1)
