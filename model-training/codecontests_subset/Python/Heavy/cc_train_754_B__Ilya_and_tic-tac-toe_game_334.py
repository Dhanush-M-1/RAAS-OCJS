def check(l):
    for i in l:
        if 'xxx' in ''.join(i):
            return True
    for i in zip(*l):
        if 'xxx' in ''.join(i):
            return True
        
    if 'xxx' in ''.join([l[i][i+1]for i in range(3)]):
        return True
    if 'xxx' in ''.join([l[i+1][i] for i in range(3)]):
        return True
    if 'xxx' in ''.join([l[i][i] for i in range(4)]):
        return True
    
    if 'xxx' in ''.join([l[i][3 - i] for i in range(4)]):
        return True
    if 'xxx' in ''.join([l[2 - i][i] for i in range(3)]):
        return True
    if 'xxx' in ''.join([l[4 - i][i] for i in range(1, 4)]):
        return True
    return False  


def main():
    l = [list(input()) for _ in range(4)]
    for i in range(4):
        for j in range(4):
            if l[i][j] != '.':
                continue
            l[i][j] = 'x'
            if check(l):
                print('YES')
                return
            l[i][j] = '.'
    print('NO')

main()
