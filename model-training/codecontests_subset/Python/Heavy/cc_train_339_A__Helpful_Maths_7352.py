import sys
withFile = 0

if(withFile == 1):
    fin     = open('input.txt', 'r')
    fout    = open('output.txt', 'w')

def getl():
    if(withFile == 0):
        return input()
    else:
        return fin.readline()
def printl(s):
    if(withFile == 0):
        print(s, end='')
    else:
        fout.write(str(s))
def get_arr():
    x = getl().split(' ')
    if(x[-1] == ''):
        x = x[:-1]
    return list(map(int, x))

a = sorted(list(map(int, getl().split('+'))))

printl(a[0])
for c in a[1:]:
    printl('+')
    printl(c)

if(withFile == 1):
    fin.close()
    fout.close()