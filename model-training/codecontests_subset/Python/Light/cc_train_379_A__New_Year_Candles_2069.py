svechi, production = list(map(int, input().split()))
hours = 0
ogarki = 0
while svechi > 0 or ogarki >= production:
    if ogarki == production:
        svechi = svechi + 1
        ogarki = 0
    svechi = svechi - 1
    ogarki = ogarki + 1
    hours = hours + 1
print(hours)