n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))



from collections import Counter

def find_diff(a, b):
    sa = set(a)
    sb = set(b)
    if len(sa) > len(sb):
        print(list(sa - sb)[0])
    else:
        ca = Counter(a)
        cb = Counter(b)
        for k in ca:
            if ca[k] > cb[k]:
                print(k)
                break

find_diff(a, b)
find_diff(b, c)