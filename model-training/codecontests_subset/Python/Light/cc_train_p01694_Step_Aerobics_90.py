#!/usr/bin/env python
# -*- coding: utf-8 -*-

while True:
    n = int(input())
    if n == 0:
        break
    status = 0
    flag = False
    point = 0
    fn = list(map(list,input().split()))
    for f in fn:
        status = status + 1 if f[1] == 'u' else status - 1
        if flag == False and status == 2:
            point += 1
            flag = True
        if flag == True and status == 0:
            point += 1
            flag = False

    print(point)