from sys import stdin, gettrace


def input():
    return stdin.buffer.readline()


t = int(input())
for _ in range(t):
    n, l, r = list(map(int, input().split()))
    count = 0
    i = 1
    while count < l:
        if i == n:
            i = 1
        count += (n - i) * 2
        i += 1
    i -= 1
    count -= (n - i) * 2
    j = i + (l - count + 1) // 2
    length = r - l + 1
    if (l % 2) == 0:
        print(j, end=' ')
        j += 1
        length -= 1
        if j > n:
            i += 1
            j = i + 1
    # print("before while i: {}, j: {}, length is {}".format(i, j, length))
    while length > 0:
        if i == n:
            i = 1
        print(i, end=' ')
        length -= 1
        if length <= 0:
            break
        print(j, end=' ')
        length -= 1
        j += 1
        if j > n:
            i += 1
            j = i + 1
    print()

# 1 2 1 3 1 4 1 5 ... 1 n 2 3 2 4 2 5 ... 2 n 3 1 ... 3 n ... n-1 1 ... n-1 n 1
# 1 2 1 3 1 4 1 5. 2 3 2 4 2 5. 3 4 3 5. 4 5. 1

