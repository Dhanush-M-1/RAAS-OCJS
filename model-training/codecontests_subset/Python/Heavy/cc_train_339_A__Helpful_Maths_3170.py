# ---------------------------------------------------------------------------------------------------- #
#! /usr/local/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=utf-8
# Copyright © 2017 pmxt <pmxt@Manjunathas-Air>
# ---------------------------------------------------------------------------------------------------- #

s = input()

l = list()

for i in range(0, len(s), 2):
    l.append(int(s[i]))

l.sort()
t = str()
j = 0

for i in range(len(s)):
    if (i % 2):
        t += '+'
    else:
        t += str(l[j])
        j += 1

print(t)