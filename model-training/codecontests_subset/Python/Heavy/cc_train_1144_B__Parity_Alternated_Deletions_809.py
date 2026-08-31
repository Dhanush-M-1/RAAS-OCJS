n = int(input())
arr = list(map(int, input().split()))
evens = []
odds = []
for i in arr:
    if i % 2 == 0:
        evens.append(i)
    else:
        odds.append(i)
evens.sort()
odds.sort()
if len(odds) < len(evens):
    count = len(odds)
    for i in range(count):
        odds.pop()
        evens.pop()
    evens.pop()
    print(sum(evens) + sum(odds))
elif len(odds) > len(evens):
    count = len(evens)
    for i in range(count):
        odds.pop()
        evens.pop()
    odds.pop()
    print(sum(evens) + sum(odds))
else:
    count = len(evens)
    for i in range(count):
        odds.pop()
        evens.pop()
    if odds and odds[-1] > evens[-1]:
        odds.pop()
    elif evens:
        evens.pop()
    print(sum(evens) + sum(odds))
