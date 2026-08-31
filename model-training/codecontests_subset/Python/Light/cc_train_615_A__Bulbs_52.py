n, m = input().split()

lamps = []

for _ in range(int(n)):
    lamps.extend(input().split()[1:])

print(('NO', 'YES')[len(set(lamps)) == int(m)])

