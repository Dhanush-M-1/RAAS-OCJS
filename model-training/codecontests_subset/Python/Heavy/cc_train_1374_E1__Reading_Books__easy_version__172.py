n, k = map(int, input().split())

common_books = []
alice_books = []
bob_books = []

for i in range(n):
    duration, alice, bob = map(int, input().split())
    if alice and bob:
        collection = common_books
    elif alice:
        collection = alice_books
    elif bob:
        collection = bob_books
    else:
        collection = None
    if collection is not None:
        collection.append(duration)

def get0(collection, idx):
    if idx < len(collection):
        return collection[idx]
    return 0

if len(bob_books) + len(common_books) < k or len(alice_books) + len(common_books) < k:
    print(-1)
else:
    for collection in (common_books, alice_books, bob_books):
        collection.sort()
    icom = 0
    iali = 0
    ibob = 0
    ncom = len(common_books)
    nali = len(alice_books)
    nbob = len(bob_books)

    total = 0
    for i in range(k):
        if icom < ncom and get0(alice_books, iali) + get0(bob_books, ibob) >= common_books[icom]:
            total += common_books[icom]
            icom += 1
        elif iali < nali and ibob < nbob:
            total += alice_books[iali]
            total += bob_books[ibob]
            iali += 1
            ibob += 1
        else:
            total += common_books[icom]
            icom += 1
    print(total)
