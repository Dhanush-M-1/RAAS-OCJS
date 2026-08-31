from sys import stdin, stdout

n = int(stdin.readline())
a = sum(map(int, stdin.readline().rstrip().split()))
b = sum(map(int, stdin.readline().rstrip().split()))
c = sum(map(int, stdin.readline().rstrip().split()))

stdout.write(str(a-b) + '\n')
stdout.write(str(b-c))