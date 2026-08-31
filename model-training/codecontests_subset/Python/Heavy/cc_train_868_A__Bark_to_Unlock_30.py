pas = input()
n = int(input())
mas = [[], []]
gas = []
for i in range(n):
    s = input()
    if s[0] == pas[1] and len(mas[1]) == 0:
        mas[1].append(s[0])
    elif s[1] == pas[0] and len(mas[0]) == 0:
        mas[0].append(s[1])
    gas.append(s)

for s in gas:
    if s == pas:
        mas = [[], []]
        mas[0].append("Kaino")
        mas[1].append("NUA_KAWAI)")
        break
    if s[0] == pas[1] and len(mas[1]) == 0:
        mas[1].append(s[0])
    elif s[1] == pas[0] and len(mas[0]) == 0:
        mas[0].append(s[1])

if len(mas[1]) + len(mas[0]) == 2:
    print("YES")
else:
    print("NO")