n, k = map(int, input().split())
books = []
alice = []
bob = []
for _ in range(n):
    book = tuple(map(int, input().split()))
    if book[1] == book[2] == 1:
        books.append(book[0])
    elif book[1] == 1:
        alice.append(book[0])
    elif book[2] == 1:
        bob.append(book[0])
        
for a, b in zip(sorted(alice), sorted(bob)):
    books.append(a+b)
print(sum(sorted(books)[:k]) if len(books) >= k else -1)
