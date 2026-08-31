#!/usr/bin/env python3

n = int(input())
alist = list(map(int, input().split()))
blist = list(map(int, input().split()))
clist = list(map(int, input().split()))

print(sum(alist) - sum(blist))
print(sum(blist) - sum(clist))
