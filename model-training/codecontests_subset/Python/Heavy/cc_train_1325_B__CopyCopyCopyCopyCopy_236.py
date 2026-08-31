import random

def bubble_sort(l):
    for t in range(len(l)):
        for i in range(len(l)-1):
            if l[i] > l[i+1]:
                l[i+1], l[i] = l[i: i+2]
    return l

num_cases = int(input())

for i in range(num_cases):
    n = int(input())
    case = list(map(lambda x: int(x),input().split(" ") ))
    prev = case.pop(0)
    count = 1
    unfound = {prev}
    for num in case:
        if num > prev:
            count += 1
            prev = num
            unfound.add(num)
        else:
            if n > 0:
                if num not in unfound:
                    unfound.add(num)
                    n -= 1
                    count += 1
    print(count)
