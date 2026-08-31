victim1, victim2 = input().split()
print(victim1, victim2)
for _ in range(int(input())):
    killed, replacement = input().split()
    if victim1 == killed:
        victim1 = replacement
    else:
        victim2 = replacement
    print(victim1, victim2)