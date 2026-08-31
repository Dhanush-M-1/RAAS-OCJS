import sys
 
n, k = [int(e) for e in input().split(' ')]
books = list()
books_map = dict()
for i in range(n):
    t, a, b = [int(e) for e in input().split(' ')]
    books.append((t, a, b, i))
    books_map[i] = (t, a, b)
 
books = sorted(books, key = lambda x : x[0] * (1 if x[1] == 1 else 1e7))
alice_pay_time = 0
alice_liked_books = list()
for book in books:
    if len(alice_liked_books) >= k:
        break
    if book[1] == 1 and book[2] == 0:
        alice_pay_time += book[0]
        alice_liked_books.append(book[3])
 
books = sorted(books, key = lambda x : x[0] * (1 if x[2] == 1 else 1e7))
bob_pay_time = 0
bob_liked_books = list()
for book in books:
    if len(bob_liked_books) >= k:
        break
    if book[2] == 1 and book[1] == 0:
        bob_pay_time += book[0]
        bob_liked_books.append(book[3])
 
books = sorted(books, key = lambda x : x[0] * (1 if x[1] == 1 and x[2] == 1 else 1e7))
 
pay_time = alice_pay_time + bob_pay_time
alice_liked_book_count = len(alice_liked_books)
bob_liked_book_count = len(bob_liked_books)
for book in books:
    if book[1] == 1 and book[2] == 1:
        if alice_liked_book_count < k or bob_liked_book_count < k:
            pay_time += book[0]
            alice_liked_book_count += 1
            bob_liked_book_count += 1
            if alice_liked_book_count > k:
                pay_time -= books_map[alice_liked_books[-1]][0]
                alice_liked_books.pop()
                alice_liked_book_count = k
            if bob_liked_book_count > k:
                pay_time -= books_map[bob_liked_books[-1]][0]
                bob_liked_books.pop()
                bob_liked_book_count = k
        elif len(alice_liked_books) == 0 or len(bob_liked_books) == 0:
            break
        elif book[0] < books_map[alice_liked_books[-1]][0] + books_map[bob_liked_books[-1]][0]:
            pay_time -= books_map[alice_liked_books[-1]][0]
            pay_time -= books_map[bob_liked_books[-1]][0]
            pay_time += book[0]
            alice_liked_books.pop()
            bob_liked_books.pop()
 
if alice_liked_book_count >= k and bob_liked_book_count >= k:
    print(pay_time)
else:
    print(-1)
