t = int(input())
while t > 0:
    n = int(input())
    grid =[]
    for i in range(n):
        a = input()
        grid.append(a)
    lol = [grid[0][1],grid[0][2],grid[1][0],grid[2][0], grid[1][1]]
    ans1 = ['0','1','0','1','1']
    ans2 = ['1','0','1','0','0']
    count = 0
    l = []
    for i in range(5):
        if ans1[i] == lol[i]:
            l.append('0')
        else:
            count += 1
            l.append('1')

    if count<3:
        print(count)
        if l[0] == '1':
            print("1 2")
        if l[1] == '1':
            print("1 3")
        if l[2] == '1':
            print("2 1")
        if l[3] == '1':
            print("3 1")
        if l[4] == '1':
            print("2 2")
    else:
        print(5-count)
        if l[0] == '0':
            print("1 2")
        if l[1] == '0':
            print("1 3")
        if l[2] == '0':
            print("2 1")
        if l[3] == '0':
            print("3 1")
        if l[4] == '0':
            print("2 2")
    t -= 1