c1, c2, c3, c4, c5 = [int(x) for x in input().split()]

b = sum([c1, c2, c3, c4, c5]) / 5

if b != int(b) or b == 0:
    print(-1)
    exit()

ic1, ic2, ic3, ic4, ic5 = [int(b)] * 5

while ic1 != c1:
    if ic1 > c1:
        ic1 -= 1
        ic2 += 1
    else:
        ic1 += 1
        ic2 -= 1

while ic2 != c2:
    if ic2 > c2:
        ic2 -= 1
        ic3 += 1
    else:
        ic2 += 1
        ic3 -= 1

while ic3 != c3:
    if ic3 > c3:
        ic3 -= 1
        ic4 += 1
    else:
        ic3 += 1
        ic4 -= 1

while ic4 != c4:
    if ic4 > c4:
        ic4 -= 1
        ic5 += 1
    else:
        ic4 += 1
        ic5 -= 1

if ic5 == c5:
    print(int(b))
else:
    print(-1)