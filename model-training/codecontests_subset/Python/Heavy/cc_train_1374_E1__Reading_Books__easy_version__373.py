import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline


def solve():
    n, k = map(int, input().split())
    books = []

    for i in range(n):
        t, a, b = map(int, input().split())
        books.append((t, a == 1, b == 1))

    books_everybody_like = []
    books_alice_like = []
    books_bob_like = []
    for b in books:
        if b[1] and b[2]:
            books_everybody_like.append(b)
        elif b[1]:
            books_alice_like.append(b)
        elif b[2]:
            books_bob_like.append(b)

    books_alice_like = sorted(books_alice_like, key=lambda x: x[0])
    books_bob_like = sorted(books_bob_like, key=lambda x: x[0])

    for a, b in zip(books_alice_like, books_bob_like):
        books_everybody_like.append((a[0] + b[0], True, True))

    if len(books_everybody_like) < k:
        print(-1)
        return

    books_everybody_like = sorted(books_everybody_like, key=lambda x: x[0])

    answer = 0
    for i in range(k):
        answer += books_everybody_like[i][0]

    print(answer)


if __name__ == '__main__':
    solve()
