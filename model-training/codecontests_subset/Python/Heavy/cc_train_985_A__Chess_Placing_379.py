# -*- coding: utf - 8 -*-
"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
|    created: 29.05.2018 15:59              |
"""""""""""""""""""""""""""""""""""""""""""""
# inp = open("input.txt", "r"); input = inp.readline; out = open("output.txt", "w"); print = out.write
TN = 1


# ===========================================


def solution():
    n = int(input())
    l = list(map(int, input().split()))
    ch = 0
    nch = 0
    l = list(sorted(l))
    for i in range(n//2):
        ch += abs(l[-i-1]-(n-2*i))
        nch += abs(l[-i-1]-(n-1-2*i))
    print(min(ch,nch))


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
# inp.close()
# out.close()
