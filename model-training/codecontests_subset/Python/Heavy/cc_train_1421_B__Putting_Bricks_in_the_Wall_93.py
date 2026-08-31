# -*- coding: utf-8 -*-
"""
Created on Sat Sep 19 16:36:57 2020

@author: lakne
"""
t = int(input())
answers = []
for _ in range(t):
    n = int(input())
    start = []
    finish = []
    answer = []
    grids = []
    c = 0
    for i in range(n):
        grid = input()
        grids.append(grid)
    start.append(grids[0][1])
    start.append(grids[1][0])
    finish.append(grids[n-2][n-1])
    finish.append(grids[n-1][n-2])
    if start[0] != start[1] and finish[0] == finish[1]:
        c = 1
        if start[0] == finish[0]:
            answer.append([str(1), str(2)])
        else:
            answer.append([str(2), str(1)])
    elif start[0] == start[1] and finish[0] == finish[1]:
        if start[0] == finish[0]:
            c = 2
            answer.append([str(1), str(2)])
            answer.append([str(2), str(1)])
        else:
            c = 0
    elif start[0] != start[1] and finish[0] != finish[1]:
        c = 2
        if start[0] == finish[0]:
            answer.append([str(1), str(2)])
            answer.append([str(n), str(n-1)])
        else:
            answer.append([str(1), str(2)])
            answer.append([str(n-1), str(n)])
    elif start[0] == start[1] and finish[0] != finish[1]:
        c = 1
        if start[0] == finish[0]:
            answer.append([str(n-1), str(n)])
        else:
            answer.append([str(n), str(n-1)])
    answers.append([c, answer])
for j in range(t):
    print(answers[j][0])
    for cord in answers[j][1]:
        print(' '.join(cord))
        