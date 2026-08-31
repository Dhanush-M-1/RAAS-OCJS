import sys
from collections import Counter

def solve(nb_books, nb_genres, books):
    counter = Counter(books)
    nb_possibilities = 0
    nb_seen = 0
    for genre, count in counter.items():
        nb_remaining_books = max(0, nb_books - nb_seen - count)
        nb_possibilities += (count * nb_remaining_books)
        nb_seen += count
    return nb_possibilities

assert solve(4, 3, [2, 1, 3, 1]) == 5
assert solve(7, 4, [4, 2, 3, 1, 2, 4, 3]) == 18

nb_books, nb_genres = map(int, input().strip().split(' '))
books = input().strip().split(' ')
print(solve(nb_books, nb_genres, books))
