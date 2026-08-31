n, m = map(int, input().split())
bulb = []

for _ in range(n):
    lst = [int(i) for i in input().split()]
    lst.pop(0)
    bulb += lst

print('YES' if len(set(bulb)) == m else 'NO')
