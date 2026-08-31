if __name__ == '__main__':
    n = int(input())
    line = list()
    for i in range(n):
        line.append(list(map(int, input().split())))
    if n < 3:
        print(n)
    else:
        res = 2
        for i in range(1, n - 1):
            if line[i][1] < line[i][0] - line[i - 1][0]:
                res += 1
            elif line[i][1] < line[i + 1][0] - line[i][0]:
                res += 1
                line[i][0] += line[i][1]
        print(res)
