#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct 18 19:52:22 2020

@author: Nille
"""

## Problem: 339A

numbersIn = str(input())
numbersWithSign = numbersIn.split()
numbers = []
for i in numbersWithSign[0]:
    if i != "+":
        numbers.append(int(i))

numbers.sort()
finalOut = ""

if len(numbers) == 1:
    finalOut = str(numbers[0])
else:
    index = 0
    while index == 0 and index != (len(numbers)-1):
        for i in numbers:
            finalOut += str(i) + "+"
            index += 1

if finalOut.endswith("+"):
    finalOut = finalOut[:-1]

print(finalOut)