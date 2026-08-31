nbCards = int(input())
cards = input()
eights = 0
otherDigits = 0
for card in cards:
    if card == "8":
        eights += 1
    else:
        otherDigits += 1
nbNumbers = 0
for loop in range(eights):
    toTake = min(10, otherDigits)
    taken = toTake
    otherDigits -= toTake
    if toTake != 10:
        toTake = min(10-toTake, eights-1)
        eights -= toTake
        taken += toTake
    if taken == 10:
        eights -= 1
        nbNumbers += 1
    else:
        break
print(nbNumbers)
