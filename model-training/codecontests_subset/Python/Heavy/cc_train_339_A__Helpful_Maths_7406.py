suma = input()
jedynki = 0
dwojki = 0
trojki = 0
plusy = 0
nowaSUMA = ""
xeniaSUMA = ""

for i in range(len(suma)):
    if suma[i] == "1":
        jedynki += 1

    elif suma[i] == "2":
        dwojki += 1

    elif suma[i] == "3":
        trojki += 1

    else:
        plusy += 1

for i in range(jedynki):
    nowaSUMA += "1+"

for i in range(dwojki):
    nowaSUMA += "2+"

for i in range(trojki):
    nowaSUMA += "3+"

for i in range(len(nowaSUMA) - 1):
    xeniaSUMA += nowaSUMA[i]

print(xeniaSUMA)