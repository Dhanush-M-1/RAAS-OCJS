word = input()
one_pos = []
two_pos = []
printed = False
for _ in range(int(input())):
    x = input()
    if word == x:
        print("YES")
        printed = True
        break
    if word[0] in x:
        if x[0] == word[0]:
            one_pos.append(0)
        if x[1] == word[0]:
            one_pos.append(1)
    if word[1] in x:
        if x[0] == word[1]:
            two_pos.append(0)
        if x[1] == word[1]:
            two_pos.append(1)


if not printed:
    if 1 in one_pos and 0 in two_pos:
        print("YES")
    else:
        print("NO")
