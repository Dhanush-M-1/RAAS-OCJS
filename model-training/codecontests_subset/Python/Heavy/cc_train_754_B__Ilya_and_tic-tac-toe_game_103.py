S = [list(input()) for i in range(4)]


def check(i, j):
    if i + 2 < 4 and S[i][j] == 'x' and S[i + 1][j] == 'x' and S[i + 2][j] == 'x': return True
    if j + 2 < 4 and S[i][j] == 'x' and S[i][j + 1] == 'x' and S[i][j + 2] == 'x': return True
    if i + 2 < 4 and j + 2 < 4 and S[i][j] == 'x' and S[i + 1][j + 1] == 'x' and S[i + 2][j + 2] == 'x': return True
    if (i + 2 < 4 and j - 2 >= 0 and S[i][j] == 'x' and S[i + 1][j - 1] == 'x' and S[i + 2][j - 2] == 'x'): return True
    return False


def solve():
    for i in range(4):
        for j in range(4):
            if S[i][j] == '.':
                S[i][j] = 'x';
                for x in range(4):
                    for y in range(4):
                        if check(x, y): return True
                S[i][j] = '.';
    return False


print("YES" if solve() else "NO")

	  		 		 		 	   	  			 		   		