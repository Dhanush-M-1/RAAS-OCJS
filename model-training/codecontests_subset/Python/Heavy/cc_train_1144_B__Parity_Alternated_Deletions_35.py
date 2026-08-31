input()

arr = [*map(int, input().split())]

last = -1

if len(arr) == 1:
    print(0)
else:
    evens = [*sorted([i for i in arr if i%2 == 0], reverse=True)]
    odds = [*sorted([i for i in arr if i%2 != 0], reverse=True)]

    if len(odds) == len(evens):
        print(0)
    else:
        if len(odds) == 0 or len(evens) == 0:
            if len(odds) == 0:
                print(sum(evens[1:]))
            else:
                print(sum(odds[1:]))
        else:
            if len(odds) > len(evens):
                print(sum(odds[len(evens) + 1:]))
            else:
                print(sum(evens[len(odds) + 1:]))
