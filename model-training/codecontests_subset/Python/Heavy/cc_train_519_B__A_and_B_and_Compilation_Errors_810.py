#!/usr/bin/env python
# coding=utf-8

import math

input_o = int(input())
input_s = list([int(x) for x in input().split()])
input_s.sort()
input_l = list([int(x) for x in input().split()])
input_l.sort()
input_m = list([int(x) for x in input().split()])
input_m.sort()
first = input_s[-1]
second = input_l[-1]
for i in range(input_o):
    if len(input_s) <= i or len(input_l) <= i:
        break
    if input_s[i] != input_l[i]:
        first = input_s[i]
        break
for i in range(input_o):
    if len(input_l) <= i or len(input_m) <= i:
        break
    if input_l[i] != input_m[i]:
        second = input_l[i]
        break
print(first)
print(second)
