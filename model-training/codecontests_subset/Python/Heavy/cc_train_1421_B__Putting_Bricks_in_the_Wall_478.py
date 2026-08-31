for _ in range(int(input())):
    n = int(input())
    matrix = []

    for i in range(n):
        s = input()
        matrix.append(s)

    s = ""
    s += matrix[0][1] + matrix[1][0] + matrix[-1][-2] + matrix[-2][-1]
    z, o = s.count("0"), s.count("1")
    
    if s[:2] == "00" and s[2:] == "11" or s[:2] == "11" and s[2:] == "00":
        print(0)
    elif z == 4 or o == 4:
        print(2)
        print(1, 2)
        print(2, 1)
    else:
        print(min(z, o))
        if z != o:
            if s[:2] == "00":
                if s[2] == "0":
                    print(n, n-1)
                elif s[3] == "0":
                    print(n-1, n)
            elif s[:2] == "11":
                if s[2] == "1":
                    print(n, n-1)
                elif s[3] == "1":
                    print(n-1, n)
            elif s[2:] == "00":
                if s[0] == "0":
                    print(1, 2)
                elif s[1] == "0":
                    print(2, 1)
            elif s[2:] == "11":
                if s[0] == "1":
                    print(1, 2)
                elif s[1] == "1":
                    print(2, 1)
        else:
            if s[:2] == "01" and s[2:] == "01":
                print(1, 2)
                print(n-1, n)
            elif s[:2] == "10" and s[2:] == "01":
                print(2, 1)
                print(n-1, n)
            elif s[:2] == "01" and s[2:] == "10":
                print(1, 2)
                print(n, n-1)
            elif s[:2] == "10" and s[2:] == "10":
                print(2, 1)
                print(n, n-1)
                
                    

    
