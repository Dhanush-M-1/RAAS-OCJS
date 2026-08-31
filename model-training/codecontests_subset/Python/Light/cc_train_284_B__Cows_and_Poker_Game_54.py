n = int(input())

daf = list(input())

if daf.count('I') == 0:
    print(daf.count('A'))
elif daf.count('I') > 1:
    print(0)
else:
    print(1)
