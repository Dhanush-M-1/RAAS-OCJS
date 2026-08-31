test_cases = range(int(input()))
for test_case in test_cases:
    n = int(input())         
    grid = []
    for i in range(n):
        new_line = [c for c in input()]
        grid.append(new_line)
    
    sr, sd = grid[0][1], grid[1][0]
    fl, fu = grid[n-1][n-2], grid[n-2][n-1]


    if sr == sd and fl == fu and sr != fl:
        print(0)
        continue
    if sr == sd and fl == fu and sr == fl:
        print(2)
        print(1,2)
        print(2,1)
        continue
    
    if sr == sd and sr == fl:
        print(1)
        print(n,n-1)
        continue
    if sr == sd and sr == fu:
        print(1)
        print(n-1, n)
        continue
    if fl == fu and fl == sr:
        print(1)
        print(1,2)
        continue
    if fl == fu and fl == sd:
        print(1)
        print(2,1)
        continue

    if fl == sd:
        print(2)
        print(n, n-1)
        print(1, 2)
        continue
    if fl == sr:
        print(2)
        print(n, n-1)
        print(2, 1)
        continue
