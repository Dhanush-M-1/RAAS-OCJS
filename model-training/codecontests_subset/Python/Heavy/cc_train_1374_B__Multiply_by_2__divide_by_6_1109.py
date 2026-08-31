from sys import stdin, stdout
t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    count = 0
    ex = 0
    if n == 1:
        stdout.write("0\n")
    else:
        while n>1:
            if n%6 == 0:
                n = n//6
                count += 1
            elif n%3 != 0:
                stdout.write("-1\n")
                ex = 1
                break
            else:
                n *= 2
                count += 1
        if ex == 0:
            stdout.write(str(count)+"\n")