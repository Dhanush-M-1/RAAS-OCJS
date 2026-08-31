t = int(input())


def count():
    n, playsandclears, flag = int(input()), [], True
    for i in range(n):
        playsandclears.append(list(map(int, input().split(' '))))
    for i in range(n):
        if playsandclears[i][0] < playsandclears[i][1]:
            flag = False
            break
        try:
            if (playsandclears[i][1] > playsandclears[i+1][1] or playsandclears[i][0] > playsandclears[i+1][0] or (playsandclears[i+1][1]-playsandclears[i][1]) > (playsandclears[i+1][0] - playsandclears[i][0])):
                flag = False
                break
        except:
            continue
        else:
            flag = True
    if flag:
        return "YES"
    else:
        return "NO"


for i in range(t):
    print(count())