def do(n, s):
    x, y = 0, 0
    for i in s:
        if i == '1':
            y += 1
        else:
            x += 1
    if x != y:
        print(1)
        print(s)
        return
    
    a, b = 0, 0
    
    for i in range(n):
        if a != b and x - a != y - b:
            print(2)
            print(s[:i] + ' ' + s[i:])
            break
        else:
            if s[i] == '0':
                a += 1
            else:
                b += 1

if __name__ == "__main__":
    n = int(input())
    s = input()
    do(n, s)

