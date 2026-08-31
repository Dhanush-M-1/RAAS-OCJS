from collections import Counter

n = int(input())
cows = input()

cows = Counter(cows)

if cows['I'] == 1:
    print(1)
else:
    if cows['I'] > 1:
        print(0)
    else:
        print(cows['A'])