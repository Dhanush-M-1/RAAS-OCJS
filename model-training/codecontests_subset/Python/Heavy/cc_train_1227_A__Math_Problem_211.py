t = int(input())
def s2i(arr):
    x = input()
    x = x.split()
    for i1 in range(2):
        arr.append(int(x[i1]))
        
for i in range(t):
    n = int(input())
    otr1 = []
    otr2 = []
    for j in range(n):
        temp = []
        s2i(temp)
        for g in range(len(temp)):
            if g == 0:
                otr1.append(temp[g])
            else:
                otr2.append(temp[g])
    frst = min(otr2)
    sec = max(otr1)
    ans = sec - frst
    if ans > 0:
        print(ans)
    else:
        print(0)