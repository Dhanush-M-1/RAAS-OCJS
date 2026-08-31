t = int(input())
for z in range(t):
    al = []
    bl = []
    new_list = []
    x, y = map(int, input().split())
    a = map(int, input().split())
    b = map(int, input().split())
    for no in a:
        al.append(no)
    for digits in b:
        bl.append(digits)
    if x > y:
        for i in range(x-y):
            bl.append(0)
    elif y > x:
        for j in range(y-x):
            al.append(0)

    for m in al:
        for n in bl:
            if m == n:
                new_list.append(m)

    new_list.sort()
    if new_list == []:
        print("NO")
    else:
        print("YES")
        print(1, new_list[0])