#!/usr/bin/env python
# coding: utf-8

# In[ ]:


T = int(input())
i = 0
while (i < T):
    i += 1
    N = int(input())
    a = [[int(i) for i in input().split()] for j in range(N)]
    correct = True
    if N == 1:
        if a[0][0] < a[0][1]:
            correct = False
    else:
        for j in range(N - 1):
            if a[j][0] > a[j + 1][0] or a[j][1] > a[j + 1][1] or a[j + 1][0] - a[j][0] < a[j + 1][1] - a[j][1] or a[j][0] < a[j][1]:
                correct = False
                break
    if correct == True:
        print('YES')
    else:
        print('NO')

