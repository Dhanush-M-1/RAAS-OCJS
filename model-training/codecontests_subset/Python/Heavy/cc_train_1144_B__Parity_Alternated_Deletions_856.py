n = int(input())

odd, even = [], []
for a in map(int, input().split()):
    if a % 2 == 0:
        even.append(a)
    else:
        odd.append(a)

odd = sorted(odd)
even = sorted(even)

if len(odd) > len(even):
    odd.pop()
    prev_odd = True
elif len(odd) < len(even):
    even.pop()
    prev_odd = False
else:
    if odd[-1] > even[-1]:
        odd.pop()
        prev_odd = True
    else:
        even.pop()
        prev_odd = False

while (len(odd) > 0 or prev_odd) and (len(even) > 0 or not prev_odd):
    if prev_odd:
        even.pop()
    else:
        odd.pop()
    prev_odd = not prev_odd

print(sum(even) + sum(odd))
