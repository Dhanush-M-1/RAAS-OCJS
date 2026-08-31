n =int (input())
first = [int(u) for u in input().split()]
sec = [int(u) for u in input().split()]
third = [int(u) for u in input().split()]

first.sort()
sec.sort()
third.sort()

for i in range(n-1):
    if first[i] != sec[i]:
        print (first[i])
        break
else:
    print (first[-1])

for i in range(n-2):
    if sec[i] != third[i]:
        print (sec[i])
        break
else:
    print (sec[-1])
