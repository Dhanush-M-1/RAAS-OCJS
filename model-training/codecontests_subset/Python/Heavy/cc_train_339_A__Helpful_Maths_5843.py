s = input()
ns = ""
ones = 0
twos = 0
threes = 0
s = s.split('+')
for char in s:
    if char == '1': ones += 1
    elif char == '2': twos += 1
    else: threes += 1

while ones > 0:
    ns += '1'
    if ones > 1:
        ns += '+'
    ones -= 1

while twos > 0:
    if ns != '' and (not '2' in ns): ns += '+'
    ns += '2'
    if twos > 1:
        ns += '+'
    twos -= 1

while threes > 0:
    if ns != '' and (not '3' in ns): ns += '+'
    ns += '3'
    if threes > 1:
        ns += '+'
    threes -= 1

print(ns)
