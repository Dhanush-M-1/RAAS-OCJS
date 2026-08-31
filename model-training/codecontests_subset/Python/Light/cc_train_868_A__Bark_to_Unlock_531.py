#!/usr/bin/env

first, last = input()

num_words = int(input())

ending_first = False
starting_last = False
found = False

for _ in range(num_words):
    wfirst, wlast = input()
    if wfirst == first and wlast == last:
        print('YES')
        found = True
        break
    if wlast == first:
        ending_first = True
    if wfirst == last:
        starting_last = True
    if ending_first and starting_last:
        print('YES')
        found = True
        break

if not found: print('NO')
