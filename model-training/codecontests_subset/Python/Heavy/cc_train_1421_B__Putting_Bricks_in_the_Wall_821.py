def mySolver(li, grid):
    g1 = int(li[0][0][1])
    g2 = int(li[1][0][0])
    g3 = int(li[grid-2][0][grid-1])
    g4 = int(li[grid-1][0][grid-2])
    count = 0
    ans = []

    if g2 == g1 and g3 == g4:
        if g1 == g3:
            ans.append([1,2])
            ans.append([2,1])
    elif g2 != g1 and g3 == g4:
        if g2 == g3:
            ans.append([2,1])
        else:
            ans.append([1,2])
    elif g2 == g1 and g3 != g4:
        if g3 == g2:
            ans.append([grid-1,grid])
        else:
            ans.append([grid,grid-1])
    else:
        if g3 == g2:
            ans.append([1,2])
            ans.append([grid-1,grid])
        else:
            ans.append([2,1])
            ans.append([grid-1,grid])

    if not ans:
        print('0')
    else:
        print(len(ans))
        for i in ans:
            print(i[0], i[1])


    

def main():
    # Read test case num
    case = int(input())
    for i in range(0,case):
        grid = int(input())
        li = []
        for j in range(grid):
           li.append(list(map(str,input().split())))
        mySolver(li, grid)

main()