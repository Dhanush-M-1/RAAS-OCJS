#!/usr/bin/env python3

n = int(input())
alist = sum(map(int, input().split(" ")))
blist = sum(map(int, input().split(" ")))
clist = sum(map(int, input().split(" ")))

print(alist - blist)
print(blist - clist)
