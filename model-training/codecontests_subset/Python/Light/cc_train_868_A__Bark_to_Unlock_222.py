pw = input()
ll = []
for i in range(int(input())):
    s = input()
    ll.append(s)
if pw in ll:
    print("YES")
else:
    status = False
    for i in ll:
        if pw[0] == i[-1]:
            for j in ll:
                if pw[-1] == j[0]:
                    status = True
                    break
        if status == True:
            print("YES")
            break
    if status ==False:
        print("NO")