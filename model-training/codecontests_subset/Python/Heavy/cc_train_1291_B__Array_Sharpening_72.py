from sys import stdin, stdout

n = int(stdin.readline())

for _ in range(n):
    nb = int(stdin.readline())
    array = list(map(int, stdin.readline().split()))
    i = 0
    a = True
    switch = False
    while i < len(array):
        if array[i] < i:
            if switch :
                a = False
                break
            else:
                array = array[i-1:][::-1]
                i = 0
                switch = True
        else:
            i += 1
    if a:
        stdout.write("Yes \n")
    else:
        stdout.write("No \n")
