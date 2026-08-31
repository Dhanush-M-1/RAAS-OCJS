from collections import deque
from operator import itemgetter
from sys import stdin, stdout

int_in = lambda: int(stdin.readline())
arr_in = lambda: [int(x) for x in stdin.readline().split()]
mat_in = lambda rows: [arr_in() for _ in range(rows)]
str_in = lambda: stdin.readline().strip()
out = lambda o: stdout.write("{}\n".format(o))
arr_out = lambda o: out(" ".join(map(str, o)))
bool_out = lambda o: out("YES" if o else "NO")
tests = lambda: range(1, int_in() + 1)
case_out = lambda i, o: out("Case #{}: {}".format(i, o))


def solve(n, k, books):
    alice_books = list(sorted(filter(lambda x: x[1] == 1 and x[2] == 0, books), key=itemgetter(0)))[:k]
    bob_books = list(sorted(filter(lambda x: x[1] == 0 and x[2] == 1, books), key=itemgetter(0)))[:k]
    shared_books = list(sorted(filter(lambda x: x[1] == 1 and x[2] == 1, books), key=itemgetter(0)))[:k]

    have = min(len(alice_books), len(bob_books))
    need = k - have
    using_shared_books = []
    if need > 0:
        if len(shared_books) < need:
            return -1
        alice_books = alice_books[:have]
        bob_books = bob_books[:have]
        using_shared_books = shared_books[:need]
        shared_books = shared_books[need:]
    shared_books = deque(shared_books)
    if have > 0:
        while len(alice_books) > 0 and len(bob_books) > 0 and len(shared_books) > 0 and alice_books[-1][0] + bob_books[-1][0] > shared_books[0][0]:
            using_shared_books.append(shared_books[0])
            alice_books.pop()
            bob_books.pop()
            shared_books.popleft()
    if len(alice_books) + len(using_shared_books) != k:
        return -1
    if len(bob_books) + len(using_shared_books) != k:
        return -1
    result = 0
    for item in alice_books:
        result += item[0]
    for item in bob_books:
        result += item[0]
    for item in using_shared_books:
        result += item[0]
    return result


if __name__ == "__main__":
    n, k = arr_in()
    books = mat_in(n)
    out(solve(n, k, books))