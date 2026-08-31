# -*- coding: utf-8 -*-

import sys
import os
import math

def second_to_str(second):
    T = second // 3600
    second -= 3600 * T

    H = second // 60
    second -= 60 * H

    S = second
    return "{:02d}:{:02d}:{:02d}".format(T, H, S)

for s in sys.stdin:
    T, H, S = map(int, s.split())
    if T == H == S == -1:
        break

    past_second = T * 3600 + H * 60 + S

    rest_second = 120 * 60 * 1 - past_second
    rest_second_3x = rest_second * 3

    print(second_to_str(rest_second))
    print(second_to_str(rest_second_3x))