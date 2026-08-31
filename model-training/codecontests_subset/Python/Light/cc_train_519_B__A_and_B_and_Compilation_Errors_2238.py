n = int(input())

errs1 = sorted([int(x) for x in input().split()])
errs2 = sorted([int(x) for x in input().split()])
errs3 = sorted([int(x) for x in input().split()])

for i in range(n - 1):
    if errs1[i] != errs2[i]:
        print(errs1[i])
        break
else:
    print(errs1[-1])

for i in range(n - 2):
    if errs2[i] != errs3[i]:
        print(errs2[i])
        break
else:
    print(errs2[-1])