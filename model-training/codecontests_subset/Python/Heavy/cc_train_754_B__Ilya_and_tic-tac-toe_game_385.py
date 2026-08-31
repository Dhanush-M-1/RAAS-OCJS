def check(i, j):
    if field[i][j] == '.':
        if field[i - 1][j] == field[i + 1][j] and field[i - 1][j] == 'x':
            return True
        elif field[i - 2][j] == field[i - 1][j] and field[i - 1][j] == 'x':
            return True
        elif field[i + 2][j] == field[i + 1][j] and field[i + 1][j] == 'x':
            return True    
        elif field[i][j + 1] == field[i][j - 1] and field[i][j - 1] == 'x':
            return True
        elif field[i][j + 2] == field[i][j + 1] and field[i][j + 1] == 'x':
            return True
        elif field[i][j - 2] == field[i][j - 1] and field[i][j - 1] == 'x':
            return True    
        elif field[i - 1][j - 1] == field[i + 1][j + 1] and field[i - 1][j - 1] == 'x':
            return True
        elif field[i - 1][j - 1] == field[i - 2][j - 2] and field[i - 1][j - 1] == 'x':
            return True
        elif field[i + 2][j + 2] == field[i + 1][j + 1] and field[i + 1][j + 1] == 'x':
            return True    
        elif field[i - 1][j + 1] == field[i + 1][j - 1] and field[i - 1][j + 1] == 'x':
            return True
        elif field[i - 2][j + 2] == field[i - 1][j + 1] and field[i - 1][j + 1] == 'x':
            return True
        elif field[i + 1][j - 1] == field[i + 2][j - 2] and field[i + 1][j - 1] == 'x':
            return True    
    return False

field = [['o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'], ['o', 'o', 'o', 'o', 'o', 'o', 'o', 'o']] + [['o', 'o'] + [i for i in input()] + ['o', 'o'] for i in range(4)] + [['o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'], ['o', 'o', 'o', 'o', 'o', 'o', 'o', 'o']]
i = 2
j = 2
while j < 6 and not check(i, j):
    i += 1
    if i == 6:
        i = 2
        j += 1
if j == 6:
    print('NO')
else:
    print('YES')