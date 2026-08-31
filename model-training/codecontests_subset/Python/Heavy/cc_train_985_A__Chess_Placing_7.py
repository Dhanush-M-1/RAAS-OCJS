#!/usr/bin/env python3
#-*- encoding:utf-8 -*-

import sys

def main():
    n = int(sys.stdin.readline())
    p = list(map(int,sys.stdin.readline().split()))
    chess = [1 if i+1 in p else 0 for i in range(n)]
    res = n*n
    first = chess[0]
    for j in [chess,chess[::-1]]:
        tmp = 0
        piece, free = [], []
        for i in range(n):
            if i % 2 and first == j[i]:
                continue
            elif i % 2:
                free.append(i)
            elif first == j[i]:
                piece.append(i)
        for i in range(len(free)):
            tmp += abs(free[i]-piece[i])
        res = min(tmp,res)
    print(res) 

main()
