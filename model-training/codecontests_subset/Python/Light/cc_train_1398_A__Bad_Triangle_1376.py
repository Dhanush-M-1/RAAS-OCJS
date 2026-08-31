from itertools import combinations

def f(lst):
    if lst[0] + lst[1] <= lst[-1]:
        return ' '.join(map(str,(1, 2, len(lst))))
    return -1

for _ in range(int(input())):
    input()
    print(f(list(map(int, input().split()))))