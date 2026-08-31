#Codeforces - - 1382 A Common Subsequence
t = int(input())
while t != 0:
    n, m = map(int,input().split())
    arrA = sorted(list(map(int,input().split())))
    arrB = sorted(list(map(int,input().split())))
    result = 0
    resultIndex = -1
    for i in range(len(arrA)):
        for j in range(len(arrB)):
            if arrA[i] == arrB[j]:
                result = 1
                resultIndex = i
                break
        if result != 0:
            break
    if result == 0:
        print('NO')
    else:
        print('YES')
        print('1 {0}'.format(arrA[resultIndex]))
    t -= 1
