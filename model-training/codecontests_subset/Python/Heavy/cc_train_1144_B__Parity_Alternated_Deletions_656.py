n = int(input())
arr = list(map(int, input().split()))

odds = []
evens = []

def place(num):
    if num %2 == 0:
        evens.append(num)
        return
    odds.append(num)

a = list(map(place, arr))

odds = sorted(odds, reverse = True)
evens = sorted(evens, reverse = True)

if len(odds) == len(evens):
    rem = 0

elif len(odds) > len(evens):
    rem = len(odds) - len(evens) -1
    if rem != 0:
        res = sum(odds[-rem:])
else:
    rem = len(evens) - len(odds) - 1
    if rem != 0:
        res = sum(evens[-rem:])

if rem == 0:
    res = 0
    
print(res)