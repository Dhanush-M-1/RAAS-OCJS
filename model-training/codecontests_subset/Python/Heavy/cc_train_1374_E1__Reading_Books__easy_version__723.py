import sys
def solve():
    n, k = map(int, sys.stdin.readline().split())
    list_book = [[],[],[]]# together, Alice, Bob
    count = [0,0,0]
    for _ in range(n):
        t, a, b = map(int, sys.stdin.readline().split())
        if a and b:
            list_book[0].append(t)
            count[0]+=1
        elif a:
            list_book[1].append(t)
            count[1]+=1
        elif b:
            list_book[2].append(t)
            count[2]+=1
    if count[0] + min(count[1], count[2]) < k:
        print(-1)
        return
    list_book[0].sort(reverse=True)
    list_book[1].sort(reverse=True)
    list_book[2].sort(reverse=True)
    result = 0
    book = k # The book which they mush read.
    result = 0
    for _ in range(k):
        next_time = 1000000000000000000000
        token = 0
        if list_book[1] and list_book[2]:
            next_time = list_book[1][-1] + list_book[2][-1]
        if list_book[0]:
            if next_time > list_book[0][-1]:
                next_time = list_book[0][-1]
                token = 1
        if token:
            list_book[0].pop()
        else:
            list_book[1].pop()
            list_book[2].pop()
        result += next_time
    print(result)
solve()