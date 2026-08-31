#author: riyan

if __name__ == '__main__':
    tc = int(input().strip())
    for t in range(tc):
        n = int(input().strip())
        arr = []
        for i in range(n):
            arr.append(tuple(map(int, input().strip().split())))
        ans = True
        for i in range(n):
            if i == 0:
                if arr[i][0] < arr[i][1]:
                    ans = False
                    break
            else:
                if arr[i - 1][0] > arr[i][0]:
                    ans = False
                    break
                if arr[i - 1][1] > arr[i][1]:
                    ans = False
                    break
                if (arr[i][0] - arr[i - 1][0]) < (arr[i][1] - arr[i - 1][1]):
                    ans = False
                    break
        if ans:
            print('YES')
        else:
            print('NO')