from sys import stdin, exit
a, b = map(int, stdin.readline().rstrip().split(' '))

hours = 1
melted = 0

while a > 0:
    a -= 1
    melted += 1
    if melted == b:
        a += 1
        melted = 0
    hours += 1

print(hours - 1)