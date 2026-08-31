# -*- coding: utf-8 -*-
"""
Created on Mon Jul 27 15:25:55 2020

@author: MridulSachdeva
"""

N = int(input())

s = list(map(int, input().split()))

odd = []
even = []
for i in s:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)

odd = sorted(odd)
even = sorted(even)

if len(odd) > len(even):
    odd, even = even, odd

count = 0
while True:
    if count % 2 == 0:
        try:
            even.pop()
            count = 1 - count
        except:
            break
    else:
        try:
            odd.pop()
            count = 1- count
        except:
            break
# print(odd)
# print(even)
print(sum(odd) + sum(even))
        
        
    

