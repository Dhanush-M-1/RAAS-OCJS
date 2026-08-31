row1, row2 = map(int, input().split())
col1, col2 = map(int, input().split())
diag1, diag2 = map(int, input().split())

for i in range(1, 10):
    a = i
    for j in range(1, 10):
        b = j
        for k in range(1, 10):
            c = k
            for l in range(1, 10):
                d = l
                if a != b and a != c and a != d and b != c and b != d and c != d:
                    if a+b == row1 and c+d == row2 and a+d == diag1 and b+c == diag2 and a+c == col1 and b+d == col2:
                        print(a,b)
                        print(c,d)
                        exit()
print('-1')
