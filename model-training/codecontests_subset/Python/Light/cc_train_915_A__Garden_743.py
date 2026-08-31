from random import randint

x,y = map(int, input().split())
arr = sorted(list(map(int, input().split())))
maxi = 1
for i in arr[::-1]:
    if y%i == 0:
        maxi = i
        break 
print(y//maxi)
