from math import *

#t = int(input())
m = []
nn = []
for i in range(1):
    #nn.append(int(input()))
    #x = list(map(int, input().split()))
    m.append(input())
flag = -1
for i in range(1):
    c1 = 0
    c2 = 0
    c3 = 0
    s = m[0]
    ss = []
    l = len(s)
    last = -1
    flag = 0
    s2 = []
    for j in range(l):
        if s[l-1-j] == '#':
            last = l-1-j
            break
    for j in range(l):
        if c2 + c3 > c1:
            print(-1)
            flag = 1
            exit()
        if s[j] == '(':
            c1 = c1 + 1
        elif s[j] == ')':
            c2 = c2 + 1
        elif s[j] == '#' and j!=last:
            c3 = c3 + 1
            #ss.append(1)
        elif s[j] == '#' and j==last:
            c3 = c3 + 1
        if c2 + c3 > c1:
            print(-1)
            flag = 1
            exit()
    ccc = c1 - c2 - c3 + 1
    c1 = 0
    c2 = 0
    c3 = 0
    for j in range(l):
        if c2 + c3 > c1:
            print(-1)
            flag = 1
            exit()
        if s[j] == '(':
            c1 = c1 + 1
        elif s[j] == ')':
            c2 = c2 + 1
        elif s[j] == '#' and j != last:
            c3 = c3 + 1
            ss.append(1)
        elif s[j] == '#' and j == last:
            c3 = c3 + ccc
            ss.append(ccc)
        if c2 + c3 > c1:
            print(-1)
            flag = 1
            exit()
print(*ss,sep=' ')