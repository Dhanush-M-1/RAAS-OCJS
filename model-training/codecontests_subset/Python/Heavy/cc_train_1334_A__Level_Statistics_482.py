def berlio(plist, clist):
    for i in range(1, len(plist)):
        if (plist[i]-plist[i-1]) < (clist[i]-clist[i-1]) or ((plist[i] < plist[i-1])) or ((clist[i] < clist[i-1])) or (plist[i] < clist[i]):
            ans = 'NO'
            break
        else:
            ans = 'YES'
    return ans

for _ in range(int(input())):
    plist = [0]
    clist = [0]
    for _ in range(int(input())):
        p, c = map(int, input().split())
        plist.append(p)
        clist.append(c)
    print(berlio(plist, clist))