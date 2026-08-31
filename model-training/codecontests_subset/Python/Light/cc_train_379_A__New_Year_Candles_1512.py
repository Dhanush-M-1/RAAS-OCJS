"""
    nombre: New Year Candles
    id: 379A
    fuente: codeforces.com
    Coder: Cgesu Coder """

a, b = map(int, input().split())
total = a
while (a // b != 0):
    total += (a//b)
    a = (a//b) + (a%b)
print(total)