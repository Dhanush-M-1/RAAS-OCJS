n, K = map(int, input().split())
counts = {}
indi = set()
for s in map(int, input().split()):
    counts[s] = counts.get(s, 0) + 1
    indi.add(s)

sizes = list(indi)
sizes.sort()

i = 0
while i < len(sizes):
    if i + 1 < len(sizes) and sizes[i] < sizes[i + 1] and sizes[i] + K >= sizes[i + 1] and counts[sizes[i]] != 1:
        counts[sizes[i]] = 1
    else:
        i += 1

i = 0
while i < len(sizes):
    if i + 1 < len(sizes) and sizes[i] < sizes[i + 1] and sizes[i] + K >= sizes[i + 1] and counts[sizes[i]] != 0:
        counts[sizes[i]] = 0
    else:
        i += 1
        
counting = 0
for key in counts.keys():
    counting += counts[key]

print(counting)