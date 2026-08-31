import sys


input = sys.stdin.readline


n = input().rstrip()
poly = list(map(int, input().split()))
removed = ''
odds = list()
evens = list()
for i in poly:
    if i%2 == 0:
        evens.append(i)
    else:
        odds.append(i)

l_o = len(odds)
l_e = len(evens)

if abs(len(odds) - len(evens)) <= 1:
    print(0)
elif l_o == 0 or l_e == 0:
    if l_o == 0:
        print(sum(evens)-max(evens))
    elif l_e == 0:
        print(sum(odds)-max(odds))
else:
    if len(odds) < len(evens):
        evens.remove(max(evens))
        removed = 'e'

    if len(odds) > len(evens):
        odds.remove(max(odds))
        removed = 'o'

    if len(odds) == len(evens):
        if max(odds) > max(evens):
            odds.remove(max(odds))
            removed = 'o'
        else:
            evens.remove(max(evens))
            removed = 'e'

    while len(odds) != 0 and len(evens) != 0:
        if removed == 'o':
            evens.remove(max(evens))
            removed = 'e'
        else:
            odds.remove(max(odds))
            removed = 'o'
    
    if removed == 'o' and evens != []:
        evens.remove(max(evens))
    if removed == 'e' and odds != []:
        odds.remove(max(odds))


    print(sum(odds) + sum(evens))
