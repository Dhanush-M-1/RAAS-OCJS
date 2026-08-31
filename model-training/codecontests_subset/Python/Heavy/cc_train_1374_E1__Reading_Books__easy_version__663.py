n, k = [int(_) for _ in input().split()]

alice = []
bob = []
both = []

for i in range(n):
    book = [int(_) for _ in input().split()]
    if book[1] == book[2] == 1:
        both.append(book[0])
    elif book[1] == 1:
        alice.append(book[0])
    elif book[2] == 1:
        bob.append(book[0])

alice.sort()
bob.sort()
both.sort()

a = b = c = t = 0
for i in range(k):
    if (a == len(alice) or b == len(bob)) and c == len(both):
        t = -1
        break
    if c < len(both) and (a == len(alice) or b == len(bob) or both[c] < alice[a] + bob[b]):
        t += both[c]
        c += 1
    else:
        t += alice[a] + bob[b]
        a += 1
        b += 1

print(t)
