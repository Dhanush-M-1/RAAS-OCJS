def arr_inp():
    return [int(x) for x in stdin.readline().split()]


# I like dynamic programming
def dp():
    mem[0] = 1
    for j in range(1, n):
        mem[j] = mem[j - 1]
        if a[j][0] - a[j][1] > a[j - 1][0]:
            mem[j] += 1
        else:
            if j < n - 1:
                if a[j][0] + a[j][1] < a[j + 1][0]:
                    mem[j] += 1
                    a[j][0] += a[j][1]
            else:
                mem[j] += 1
    return mem[n - 1]


from collections import defaultdict
from sys import stdin

n = int(input())
a, mem = [arr_inp() for i in range(n)], defaultdict(lambda: -1)
print(dp())
