import sys

def fast_input():
    return sys.stdin.readline().strip()

def data_input():
    return [int(x) for x in fast_input().split()]

def binary_search(array, x):
    left, right = -1, len(array)
    while left + 1 != right:
        middle = (left + right) // 2
        if array[middle] >= x:
            right = middle
        elif array[middle] < x:
            left = middle
    return right

def solve_of_problem():
    n, m = data_input()
    s = fast_input()
    p = sorted(data_input()) + [n]
    alp = {}
    m += 1
    for i in range(97, 123):
        alp[chr(i)] = (0, 0)
    count = 0
    for i in range(n):
        while i == p[count]:
            count += 1
            for j in range(97, 123):
                alp[chr(j)] = (alp[chr(j)][0] + alp[chr(j)][1], alp[chr(j)][1])
        alp[s[i]] = (alp[s[i]][0] + 1, alp[s[i]][1] + 1)
    ans = []
    for i in range(97, 123):
        ans.append(str(alp[chr(i)][0]))
    print(' '.join(ans))
    return

for ______ in range(int(fast_input())):
    solve_of_problem()
