x = input()
a, b = int(x.split()[0]), int(x.split()[1])
total = a
s = a
div = a // b
mod = 0
while div > 0:
    div = s // b
    mod = s % b
    total += div
    s = div + mod

print(total)
