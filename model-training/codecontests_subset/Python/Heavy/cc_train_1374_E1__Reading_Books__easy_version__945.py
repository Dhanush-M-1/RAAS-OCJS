n, k = map(int, input().split())
books = []
booksA = []
booksB = []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 0:
        booksA.append(t)
    elif a == 0 and b == 1:
        booksB.append(t)
    elif a == 1 and b == 1:
        books.append(t)

booksA.sort(reverse=True)
booksB.sort(reverse=True)
books.sort(reverse=True)

t = 0
for _ in range(k):
    if not books:
        if (not booksA or not booksB):
            t = -1
            break
        else:
            t += booksA.pop() + booksB.pop()
    elif (not booksA or not booksB) or books[-1] < booksA[-1] + booksB[-1]:
        t += books.pop()
    else:
        t += booksA.pop() + booksB.pop()
print(t)

