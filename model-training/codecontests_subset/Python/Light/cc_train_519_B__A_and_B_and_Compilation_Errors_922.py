input()
errors1 = [int(_) for _ in input().split()]
errors2 = [int(_) for _ in input().split()]
errors3 = [int(_) for _ in input().split()]

errors1.sort()
errors2.sort()
errors3.sort()

for i in range(len(errors2)):
    if errors1[i] != errors2[i]:
        print(errors1[i])
        break
else:
    print(errors1[-1])

for i in range(len(errors3)):
    if errors2[i] != errors3[i]:
        print(errors2[i])
        break
else:
    print(errors2[-1])

