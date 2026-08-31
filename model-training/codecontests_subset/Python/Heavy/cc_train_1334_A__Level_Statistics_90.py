def poly():
    tab = []
    n = 0
    boo = 0
    for i in range(int(input())):
        tab = []
        n = int(input())
        boo = 0
        tab.append(input().split(" "))
        if int(tab[0][0]) < int(tab[0][1]):
            boo = 1
        for j in range(n-1):
            tab.append(input().split(" "))
            if int(tab[1][0]) - int(tab[0][0]) < int(tab[1][1]) - int(tab[0][1]):
                boo = 1
            if int(tab[1][0]) < int(tab[0][0]):
                boo = 1
            if int(tab[1][1]) < int(tab[0][1]):
                boo = 1
            tab.pop(0)
        if boo == 0:
            print("YES")
        else:
            print("NO")
            
poly()
