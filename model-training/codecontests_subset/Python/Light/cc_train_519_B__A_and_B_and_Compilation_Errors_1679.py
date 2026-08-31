# coding=utf-8

if __name__ == '__main__':
    n = int(input())
    n = int(n)
    line0 = list(str(input()).split())
    line1 = list(str(input()).split())
    line2 = list(str(input()).split())
    line0.sort()
    line1.sort()
    line2.sort()
    for i in range(n):
        if i == n - 1:
            print(line0[i])
        elif line0[i] != line1[i]:
            print(line0[i])
            break
    for i in range(n - 1):
        if i == n - 2:
            print(line1[i])
        elif line1[i] != line2[i]:
            print(line1[i])
            break
