# coding=utf-8

if __name__ == '__main__':
    n, m = str(input()).split()
    n = int(n)
    m = int(m)
    line = [0] * m
    for i in range(n):
        temp_line = str(input()).split()
        if len(temp_line) > 1:
            for it in temp_line[1:]:
                line[int(it) - 1] = 1
    if 0 in line:
        print('NO')
    else:
        print('YES')
