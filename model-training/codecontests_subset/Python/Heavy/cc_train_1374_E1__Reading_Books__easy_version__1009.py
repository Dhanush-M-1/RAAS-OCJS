def next():
    return [int(x) for x in input().split()]

class book:
    def __init__(self, t, a, b):
        self.t = t
        self.a = a
        self.b = b

if __name__ == '__main__':
    n, k = next()
    books = []
    for _ in range(n):
        t, a, b = next()
        books.append(book(t, a, b))
    oo = list(map(lambda x: x.t, filter(lambda x: x.a == 1 and x.b == 1, books)))
    zo = list(sorted(map(lambda x: x.t, filter(lambda x: x.a == 0 and x.b == 1, books))))
    oz = list(sorted(map(lambda x: x.t, filter(lambda x: x.a == 1 and x.b == 0, books))))
    mi = min(len(zo), len(oz))
    for i in range(mi):
        oo.append(zo[i] + oz[i])

    if len(oo) < k:
        print(-1)
    else:
        print(sum(sorted(oo)[:k]))
