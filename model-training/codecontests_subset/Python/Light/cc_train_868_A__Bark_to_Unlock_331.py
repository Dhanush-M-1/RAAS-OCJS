want, n = input(), int(input())
words = []

for i in range(n):
    words.append(input())

can = False
if words.count(want) > 0:
    can = True

for i in range(n):
    if words[i][0] == want[1]:
        for j in range(n):
            if words[j][1] == want[0]:
                can = True

if can:
    print("YES")
else:
    print("NO")