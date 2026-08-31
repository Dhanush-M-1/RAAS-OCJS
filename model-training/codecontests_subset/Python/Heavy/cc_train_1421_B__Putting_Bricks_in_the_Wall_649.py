if __name__ == "__main__":
    t = int(input())
    ans = []
    for u in range(t):
        n = int(input())
        way = []
        key = ['0', '1']
        for i in range(n):
            way.append(input())
        if way[0][1] == way[1][0]:
            if way[n - 1][n - 2] == way[n - 2][n - 1]:
                if way[n - 1][n - 2] == way[0][1]:
                    ans.append(2)
                    ans.append(str(n) + ' ' + str(n - 1))
                    ans.append(str(n - 1) + ' ' + str(n))
                else:
                    ans.append(0)
            else:
                if way[n - 1][n - 2] == way[0][1]:
                    ans.append(1)
                    ans.append(str(n) + ' ' + str(n - 1))
                else:
                    ans.append(1)
                    ans.append(str(n - 1) + ' ' + str(n))
        else:
            if way[n - 1][n - 2] == way[n - 2][n - 1]:
                if way[n - 1][n - 2] == way[0][1]:
                    ans.append(1)
                    ans.append(str(1) + ' ' + str(2))
                else:
                    ans.append(1)
                    ans.append(str(2) + ' ' + str(1))
            else:
                if way[1][0] == way[n - 1][n - 2]:
                    ans.append(2)
                    ans.append(str(1) + ' ' + str(2))
                    ans.append(str(n) + ' ' + str(n - 1))
                else:
                    ans.append(2)
                    ans.append(str(2) + ' ' + str(1))
                    ans.append(str(n) + ' ' + str(n - 1))
    for a in ans:
        print(a)
                    
