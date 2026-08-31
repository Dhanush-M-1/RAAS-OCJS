# -*- coding: utf-8 -*-
def f(n1, n2, n3, n4):
    if n3 == n1:
        return n4, n2
    else:
        return n1, n4
n1, n2 = input().split(' ')
n = int(input())
l = [[n1,n2]]
for i in range(n):
    n1,n2 = input().split(' ')
    n1,n2 = f(l[i][0], l[i][1], n1, n2)
    l.append([n1,n2])
for i in range(n+1):
    print(l[i][0], l[i][1])
