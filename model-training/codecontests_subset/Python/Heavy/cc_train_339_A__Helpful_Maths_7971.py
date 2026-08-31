i = input()
new = str()
odin = int(0)
dva = int(0)
tri  =int(0)
plus = int(0)
y = int(0)
while y < len(i):
    if i[y] == '1':
        odin += 1
    if i[y] == '2':
        dva += 1
    if i[y] == '3':
        tri += 1
    if i[y] == '+':
        plus += 1
    y += 1
while odin > 0:
    new += '1'
    if plus > 0:
        new += '+'
        plus -= 1
    odin -= 1
while dva > 0:
    new += '2'
    if plus > 0:
        new += '+'
        plus -= 1
    dva -= 1
while tri > 0:
    new += '3'
    if plus > 0:
        new += '+'
        plus -= 1
    tri -= 1
print(new)
