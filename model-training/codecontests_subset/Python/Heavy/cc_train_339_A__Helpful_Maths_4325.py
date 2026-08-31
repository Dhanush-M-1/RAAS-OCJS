k = input()
x = len(k)
one, two, three = 0, 0, 0
for i in range(0, x, 2):
    if k[i] == "1":
        one += 1
    elif k[i] == "2":
        two += 1
    else:
        three += 1
newlist = []
for i in range(0, x):
    if i == 1:
        newlist.append("+")
    elif i % 2 != 0:
        newlist.append("+")

    elif one != 0:
        newlist.append("1")
        one -= 1
    elif two != 0:
        newlist.append("2")
        two -= 1
    else:
        newlist.append("3")
        three -= 1

print(*newlist,sep="")