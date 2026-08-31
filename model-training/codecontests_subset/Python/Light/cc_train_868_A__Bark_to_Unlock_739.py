def Kashtanka(pw,n):
    lst = []
    for i in range(n):
        lst.append(input())
        if lst[i] == pw :
            return "YES"

    temp = 1
    for j in range(n):
        if lst[j][1] == pw[0]:
            temp = 0

    if temp :
        return "NO"

    for l in range(n):
        if pw[1] == lst[l][0]:
            return "YES"

    return "NO"

print(Kashtanka(input(),int(input())))