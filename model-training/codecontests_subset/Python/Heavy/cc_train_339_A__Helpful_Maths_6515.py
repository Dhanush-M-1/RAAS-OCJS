# Helpful Maths

def toString(lis):
    return "".join(lis)


string = str(input())

strlist = list(string)

data = []
signs = []

final = []

for x in range (0, len(string)):
    if x % 2 == 0:
        data.append(strlist[x])
    elif x % 2 != 0:
        signs.append(strlist[x])
        
data.sort()
fdata = 0
fsigns = 0

for y in range (0, len(string)):
    if y % 2 == 0:
        final.append(data[fdata])
        fdata += 1
    if y % 2 != 0:
        final.append(signs[fsigns])
        fsigns += 1
        
print(toString(final))