def validNumberCount(cards):
    eights = 0
    for card in cards:
        if card == '8':
            eights += 1
    return min(len(cards) // 11, eights)
    
n = int(input())
cards = input()
print(validNumberCount(cards))