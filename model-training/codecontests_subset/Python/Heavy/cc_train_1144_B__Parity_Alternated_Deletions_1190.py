n = int(input())
array = sorted(list(map(int, input().split())), reverse = True)
odds = []
evens = []


def check(number):
    if number % 2 == 0:
        return True


for x in array:
    if check(x):
        evens.append(x)
    else:
        odds.append(x)
lo = len(odds)
le = len(evens)
if lo > le:
    sums = 0
    sums += sum(evens)
    sums += sum(odds[0: le + 1])
    print(sum(array) - sums)
else:
    sums = 0
    sums += sum(odds)
    sums += sum(evens[0: lo + 1])
    print(sum(array) - sums)
