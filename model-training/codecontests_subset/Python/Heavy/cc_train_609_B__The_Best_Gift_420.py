from math import floor
from functools import reduce

def ncr(n, r):
    return floor(reduce(lambda x,y: x * y, [(n-i)/(i+1) for i in range(r)]))

def main():
    [nBooks, nGenres] = list(map(int, input().split(" ")))
    books = list(map(int, input().split(" ")))

    # count num in each genre
    genreCounts = {}
    for genre in books:
        if genre not in genreCounts:
            genreCounts[genre] = 1
        else:
            genreCounts[genre] += 1
            
    numInvalidPairs = 0
    for _,v in genreCounts.items():
        numInvalidPairs += ncr(v, 2)

    print("{}".format(floor(ncr(len(books),2) - numInvalidPairs)))

main()