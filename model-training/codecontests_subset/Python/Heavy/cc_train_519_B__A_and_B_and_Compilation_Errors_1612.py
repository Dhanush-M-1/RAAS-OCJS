N, First, Second, Third = int(input()), sorted(list(map(int, input().split()))), sorted(
    list(map(int, input().split()))), sorted(list(map(int, input().split())))
Check, i = False, 0
while i < N - 1:
    if First[i] != Second[i]:
        Check = True
        break
    i += 1
print(First[i] if Check else First[-1])
Check, i = False, 0
while i < N - 2:
    if Second[i] != Third[i]:
        Check = True
        break
    i += 1
print(Second[i] if Check else Second[-1])

# UB_CodeForces
# Advice: Be patient toward achieving your goals
# Location: Here in Bojnord
# Caption: After long time being far and busy with apply works
# CodeNumber: 723
