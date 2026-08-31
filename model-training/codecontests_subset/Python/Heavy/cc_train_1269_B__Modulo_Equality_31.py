n, m = map(int, input().split())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

#-----
count_a = 0
candidates = set()
freqs_a, freqs_b = dict(), dict()
for x in a:
    if x in freqs_a:
        freqs_a[x] += 1
    else:
        freqs_a[x] = 1
for y in b:
    if y in freqs_b:
        freqs_b[y] += 1
    else:
        freqs_b[y] = 1

temp = a[0]
for y in freqs_b:
    if freqs_b[y] == freqs_a[temp]:
        candidates.add((y-a[0]) % m)

candidates = list(candidates)
candidates.sort()
trial = True
while trial:
    for c in candidates:
        if trial:
            possible = True
            for x in freqs_a:
                if (x + c) % m not in freqs_b:
                    possible = False
                else:
                    if freqs_b[(x + c) % m] != freqs_a[x]:
                        possible = False
            if possible:
                print (c)
                trial = False
                
