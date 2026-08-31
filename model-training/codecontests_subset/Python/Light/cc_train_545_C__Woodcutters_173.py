l = []
for item in range(int(input())):
    f,h = map(int,input().split())
    l.append((f,h))

lastOccupy = l[0][0]
count = [1,2][len(l) > 1]
for i,c in enumerate(l[1:-1], 1):
    x,h = c
    if x - h > lastOccupy:
        lastOccupy = x
        count+=1
    elif x + h < l[i + 1][0]:
        lastOccupy = x + h
        count += 1
    else:
        lastOccupy = x
print(count)
