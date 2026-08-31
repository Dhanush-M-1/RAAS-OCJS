#!/usr/bin/env python
# coding=utf-8

input_s = input().split(' ')
n = int(input_s[0])
m = int(input_s[1])
mount = n
while n >= m:
    mount += n // m
    n = n // m + n % m
print(mount)
