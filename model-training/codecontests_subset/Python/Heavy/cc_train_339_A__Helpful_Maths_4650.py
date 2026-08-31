#!/usr/bin/python
import sys

finish = ''
tC = ''
thC = ''
n = 0
ones = 0
twos = 0
thres = 0
def adder(number):
    global ones, twos, thres, tC, thC
    if number == 1:
        ones = ones + 1
    elif number == 2:
        twos = twos + 1
        tC = '+'
    elif number == 3:
        thres = thres + 1
        thC = '+'

for l in sys.stdin:
    for k in l:
        if n == 0:
            adder(int(k))
        elif n % 2 == 0:
            adder(int(k))
        n = n + 1
    break

if ones > 0:
    finish = '1'
    while ones > 1:
        finish = finish + '+'
        finish = finish + '1'
        ones = ones - 1
    if tC:
        finish = finish + '+'
    elif thC:
        finish = finish + '+'


if twos > 0:
    finish = finish + '2'
    while twos > 1:
        finish = finish + '+'
        finish = finish + '2'
        twos = twos - 1
    if thC:
        finish = finish + '+'
if thres > 0:
    finish = finish + '3'
    while thres > 1:
        finish = finish + '+'
        finish = finish + '3'
        thres = thres - 1

print(finish)
