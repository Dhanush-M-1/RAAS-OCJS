import sys
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
lst = []
r1l = []
r2l = []
c1l = []
c2l = []
d1l = []
d2l = []
newlist = []
perfectlist = []

for i in range(10):
    for y in range(10):
        lst.append([i,y])
for item in lst:
    if sum(item) == r1:
        r1l.append(item)
    if sum(item) == r2:
        r2l.append(item)
    if sum(item) == c1:
        c1l.append(item)
    if sum(item) == c2:
        c2l.append(item)
    if sum(item) == d1:
        d1l.append(item)
    if sum(item) == d2:
        d2l.append(item)
for item1 in r1l:
    for item2 in r2l:
        if item1[0] + item2[0] == c1 and item1[1] + item2[1] == c2:
            newlist.append([item1,item2])
for item in newlist:
    r11,r22 = item
    if r11[0] + r22[1] == d1 and r11[1] + r22[0] == d2:
        perfectlist.append([r11,r22])
if perfectlist == []:
    print(-1)
    sys.exit()
y = perfectlist[0]
if y == [] or y[0][0] == y[0][1] or y[0][0] == y[1][0] or y[0][0] == y[1][1] or y[0][1] == y[1][0] or y[0][1] == y[1][1] or y[1][1] == y[1][0] or y[0][0] == 0 or y[0][1] == 0 or y[1][0] == 0 or y[1][1] == 0:
    print(-1)
    sys.exit()
print(y[0][0],y[0][1])
print(y[1][0],y[1][1])
