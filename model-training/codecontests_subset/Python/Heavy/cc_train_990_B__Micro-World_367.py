# -*- coding: utf - 8 -*-
"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
|    created: 10.06.2018 15:33              |
"""""""""""""""""""""""""""""""""""""""""""""
# inp = open("input.txt", "r"); input = inp.readline; out = open("output.txt", "w"); print = out.write
TN = 1


# ===========================================


def solution():
    n, K = map(int, input().split())
    a = sorted(list(map(int, input().split())))
    ans = 0
    for i in range(1, len(a)):
        if (a[i] > a[i-1]) and (a[i] <= (a[i-1]+K)):
            j = i-1
            while j >= 0 and a[j] == a[i-1]:
                ans += 1
                j -= 1
    print(n-ans)


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
# inp.close()
# out.close()
