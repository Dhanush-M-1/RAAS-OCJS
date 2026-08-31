#!/usr/bin/env python3

n = int(input().strip())
l = list(map(int, input().split()))
l_odd = [x for x in l if x % 2 != 0]
l_even = [x for x in l if x % 2 == 0]

prev = None

for i in range(n):
    if i == 0:
        if len(l_odd) != len(l_even) and len(l_odd) > len(l_even):
            del l_odd[l_odd.index(max(l_odd))]
            prev = False
        elif len(l_odd) != len(l_even) and len(l_odd) < len(l_even):
            del l_even[l_even.index(max(l_even))]
            prev = True
        else:
            temp = max(l)
            if temp % 2 == 0:
                del l_even[l_even.index(temp)]
                prev = True
            else:
                prev = False
                del l_odd[l_odd.index(temp)]
    if prev and len(l_odd) > 0:
        del l_odd[l_odd.index(max(l_odd))]
        prev = False
    elif not prev and len(l_even) > 0:
        del l_even[l_even.index(max(l_even))]
        prev = True

print(sum(l_odd + l_even))
