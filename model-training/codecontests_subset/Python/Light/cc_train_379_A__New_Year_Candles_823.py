from sys import stdin, stdout
a,b  = stdin.readline().split()
a, b = [int(a), int(b)]
print(a+ ((a-1)//(b-1)))