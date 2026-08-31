# -*- coding: utf-8 -*-
"""
Created on Wed Oct 24 23:28:38 2018

@author: Quaint Sun
"""


'''
n=int(input())
first =input().split()
second=input().split()
third =input().split()
#if n<=1000:
for j in second:
    if j in first:
        first.remove(j)
print(first[0])

for k in third:
    if k in second:
        second.remove(k)
print(second[0])
'''
'''
else:
    for j in first:
        if j not in second:
            print(int(j))
            break
    for j in second:
        if j not in third:
            print(int(j))
            break
'''


n = int(input())
A = sum(map(int, input().split()))
B = sum(map(int, input().split()))
C = sum(map(int, input().split()))

print(A-B)
print(B-C)





