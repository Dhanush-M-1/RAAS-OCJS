ini = []
total = 0
ls = []

def inp():
    global ini, total, ls
    ini = input().split(' ')
    total = int(input())
    for i in range(total):
        ls.append(input().split(' '))

def printls(ls):
    print(ls[0]+' '+ls[1])

def solve():
    global ini, total, ls
    printls(ini)
    for pair in ls:
        xx = [i for i in ini+pair if (ini+pair).count(i) == 1]
        printls(list(xx))
        ini = list(xx)

if __name__=='__main__':

    inp()
    solve()