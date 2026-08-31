# -*- coding: utf-8 -*-
"""
Created on Thu Jul  9 17:46:11 2020

@author: MridulSachdeva
"""


cases = int(input())

answers = []

for i in range(cases):
    n = int(input())
    num = 0
    while n != 1:
        if n % 3 != 0 and n != 1:
            num = -1
            answers.append(num)
            break
        elif n == 1:
            answers.append(num)
            break
        elif n % 6 != 0:
            n *= 2
            num += 1
        else:
            n //= 6
            num += 1
    else:
        answers.append(num)
        
for i in answers:
    print(i)
                        