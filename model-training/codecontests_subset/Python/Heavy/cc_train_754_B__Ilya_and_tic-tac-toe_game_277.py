def verify(x):
    won = 0

    for row in x:
        won += 'xxx' in row

    xt = ["".join([line[i] for line in x]) for i in range(4)]
    for col in xt:
        won += 'xxx' in col

    for mat in [x, [line[::-1] for line in x]]:
        won += 'xxx' in mat[0][0] + mat[1][1] + mat[2][2] + mat[3][3]
        won += 'xxx' in mat[0][1] + mat[1][2] + mat[2][3]
        won += 'xxx' in mat[1][0] + mat[2][1] + mat[3][2]

    return won

def split_in_rows(x):
    return [x[i:i+4] for i in range(0, len(x), 4)]


if __name__ == '__main__':
    nlines = 4
    lines = list()
    for _ in range(nlines):
        lines.append(input())
    lines = "".join(lines)

    won = 0
    i = 0
    while won == 0 and i < len(lines):
        if lines[i] == '.':
            won += verify(split_in_rows(lines[:i]+'x'+lines[i+1:]))
        i += 1
    if won > 0:
        print("YES")
    else:
        print("NO")