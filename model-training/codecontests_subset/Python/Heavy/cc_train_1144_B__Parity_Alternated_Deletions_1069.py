#!/usr/local/bin/python3
# -*- coding: utf-8 -*-

n = input()
input_ = input().split()
nums = list(map(int, input_))


odd = 0
even = 0

nums.sort()

oddNum  = []
evenNum = []
for i in nums:
    if i % 2:
        odd += 1
        oddNum.append(i)
    else:
        even += 1
        evenNum.append(i)

if odd == even or abs(odd - even) == 1:
    print(0)
else:
    ans = 0
    dif = abs(odd - even)
    dif -= 1
    if odd > even:
        print(sum(oddNum[0:dif]))
    else:
        print(sum(evenNum[0:dif]))

