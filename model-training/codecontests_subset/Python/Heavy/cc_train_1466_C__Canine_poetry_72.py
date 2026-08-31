#!/usr/bin/env python3.9

for _ in range(int(input())):
    poem = list(input())
    if len(poem) == 1:
        print(0)
        continue

    free = {chr(num) for num in range(ord('a'), ord('z')+1)}

    n_chngs = 0
    free -= set(poem[:2])

    for i in range(1, 2):
        pivot = poem[i]
        if poem[i-1] == pivot:
            cand = free.pop()
            while any(cand == suff for suff in poem[i+1:i+3]):
                cand = free.pop()

            poem[i] = cand
            n_chngs += 1

    for i in range(2, len(poem)):
        pivot = poem[i]
        if poem[i-2] == pivot or pivot == poem[i-1]:
            cand = free.pop()
            while any(cand == suff for suff in poem[i+1:i+3]):
                cand = free.pop()

            poem[i] = cand
            n_chngs += 1
        free.add(poem[i-2])

    # poem = ''.join(poem)
    # print(f'{poem=}')
    print(n_chngs)
