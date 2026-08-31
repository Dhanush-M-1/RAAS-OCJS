from sys import stdin, stdout

n, x, y = map(int, stdin.readline().split())

if (x / n) * 100 >= y:
    stdout.write('0')
else:
    l = 0
    r = n * y
    
    while r - l > 1:
        m = (r + l) // 2
        
        if (x + m) / n * 100 >= y:
            r = m
        else:
            l = m
    
    stdout.write(str(r))