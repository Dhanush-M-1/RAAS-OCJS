n, wizards, percent = map(int, input().split())
import math
people = math.ceil(percent*n/100)
if people <= wizards:
    print(0)
else:
    print(people - wizards)
