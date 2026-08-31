def retar():
    a = []
    s = str(input().strip())
    for i in s:
        a.append(i)
    return a
k=[]
k.append(retar())
k.append(retar())
k.append(retar())
k.append(retar())



def mcell(x,y):
    try:
        if k[y][x]=="x" and x>=0 and y >=0:
            return True
        else:
            return False
    except:
        return False


def test(x,y):
    if k[y][x]==".":
        if (mcell(x-1, y) and mcell(x+1, y)) or (mcell(x, y+1) and mcell(x, y-1)) or (mcell(x-1, y+1) and mcell(x+1, y-1)) or (mcell(x-1, y-1) and mcell(x+1, y+1)):
            return True
        if (mcell(x-1, y) and mcell(x-2, y)) or (mcell(x+1, y) and mcell(x+2, y)):
            return True
        if (mcell(x, y+1) and mcell(x, y+2)) or (mcell(x, y-1) and mcell(x, y-2)):
            return True
        if (mcell(x-1,y+1) and mcell(x-2,y+2)) or (mcell(x+1,y+1) and mcell(x+2,y+2)) or (mcell(x-1,y-1) and mcell(x-2, y-2)) or (mcell(x+1, y-1) and mcell(x+2, y-2)):
            return True
    else:
        return False

ress = "NO"
for i in range (0,4):
    for j in range(0,4):
        if test(i,j):
            ress="YES"
            break
print(ress)
