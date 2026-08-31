# -*- coding: utf-8 -*-

# Baqir Khan
# Software Engineer (Backend)

from collections import defaultdict

n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

h1 = defaultdict(int)
h2 = defaultdict(int)
errors = set()
e1 = None

for i in a:
    h1[i] += 1
    h2[i] += 1

for i in b:
    h1[i] -= 1

for i in h1:
    if h1[i]:
        print(i)
        e1 = i
        break

for i in c:
    h2[i] -= 1

h2[e1] -= 1

for i in h2:
    if h2[i]:
        print(i)
        break
