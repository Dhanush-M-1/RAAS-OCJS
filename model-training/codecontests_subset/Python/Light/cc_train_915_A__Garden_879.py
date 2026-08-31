#!/usr/bin/env python
lst = list(map(int, input().split(' ')))
buckets = list(map(int, input().split(' ')))
buckets.sort()

no_of_buckets = lst[0]
length_garden = lst[1]

for i in range(no_of_buckets-1,-1, -1):
    if length_garden % buckets[i] == 0:
        print(length_garden//buckets[i])
        break
