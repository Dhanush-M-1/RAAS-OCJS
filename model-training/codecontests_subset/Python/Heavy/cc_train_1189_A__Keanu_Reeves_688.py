n = int(input())
s = input()
k = 0
f_s = ""
def GoodCh(st):
    if not st:
        return False
    else:
        one = 0
        zero = 0
        for i in st:
            if i == "1":
                one+=1
            elif i == "0":
                zero+=1
        if one == zero:
            return False
        else:
            return True


a = []
bs = ""  

ans = []

def answer(st,arr,bst):
    for i in range(len(st)):
        if len(st) == 1:
            i = 1
        substr = st[0:i]
        if GoodCh(substr) == True:
            bst = substr
    st = st[len(substr):]
    arr.append(bst)
    bst = ""
    if not st:
        return arr
    else:
        return answer(st,arr,bst)

if GoodCh(s) == True:
    k = 1
    f_s = s
else:
    ans = answer(s,a,bs)
    k = len(ans)
    for l in ans:
        f_s += l +" "
print(k)
print(f_s)
