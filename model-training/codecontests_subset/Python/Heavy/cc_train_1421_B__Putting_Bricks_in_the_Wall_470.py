t = int(input())

for _ in range(t):
    n = int(input())
    grid = []
    
    for i in range(n):
        grid.append([i for i in input().strip()])
        
    first = grid[1][0]
    second = grid[0][1]
    third = grid[n-1][n-2]
    fourth = grid[n-2][n-1]
    
    if first == second == third == fourth:
        print(2)
        print(2, 1)
        print(1, 2)
    elif first == second and third == fourth:
        print(0)
        
    elif first == "1" and second == "1" and third == "1" and fourth == "0":
        print(1)
        print(n, n-1)
    elif first == "1" and second == "1" and third == "0" and fourth == "1":
        print(1)
        print(n-1, n)
    elif first == "1" and second == "0" and third == "1" and fourth == "1":
        print(1)
        print(2, 1)
    elif first == "0" and second == "1" and third == "1" and fourth == "1":
        print(1)
        print(1, 2)
        
    elif first != "1" and second != "1" and third != "1" and fourth != "0":
        print(1)
        print(n, n-1)
    elif first != "1" and second != "1" and third != "0" and fourth != "1":
        print(1)
        print(n-1, n)
    elif first != "1" and second != "0" and third != "1" and fourth != "1":
        print(1)
        print(2, 1)
    elif first != "0" and second != "1" and third != "1" and fourth != "1":
        print(1)
        print(1, 2)
        
    elif first == "0" and second == "1" and third == "1" and fourth == "0":
        print(2)
        print(2, 1)
        print(n, n-1)
    elif first == "1" and second == "0" and third == "0" and fourth == "1":
        print(2)
        print(2, 1)
        print(n, n-1)
    elif first == "1" and second == "0" and third == "1" and fourth == "0":
        print(2)
        print(1, 2)
        print(n, n-1)
    elif first == "0" and second == "1" and third == "0" and fourth == "1":
        print(2)
        print(1, 2)
        print(n, n-1)
    