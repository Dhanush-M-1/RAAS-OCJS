from math import inf
from queue import Queue

n, k = [int(_) for _ in input().split()]
books = [tuple(int(_) for _ in input().split()) for __ in range(n)]
if sum(_[1] for _ in books) < k or sum(_[2] for _ in books) < k:
    print(-1)
else:
    mem = {}
    books = sorted(books)
    alice_times = []
    bob_times = []
    both_times = []
    for t, a, b in books:
        if a and b:
            both_times.append(t)
        elif a:
            alice_times.append(t)
        elif b:
            bob_times.append(t)
    bob_times.append(inf)
    alice_times.append(inf)
    both_times.append(inf)
    t = 0
    i = j = l = 0
    alice_k = bob_k = 0
    while alice_k < k or bob_k < k:
        if both_times[l] < alice_times[i] + bob_times[j]:
            t += both_times[l]
            alice_k += 1
            bob_k += 1
            l += 1
        else:
            t += alice_times[i] + bob_times[j]
            i += 1
            j += 1
            alice_k += 1
            bob_k += 1


    print(t)