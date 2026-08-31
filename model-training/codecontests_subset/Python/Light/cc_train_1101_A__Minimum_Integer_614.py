'''
sys.stdin.readline() instead of input() and using PyPy instead of Python speeds up this solution greatly.

stdout, takes only str as argument, also it does not end line like print do.
'''
#from sys import stdin, stdout
t = int(input())

for i in range(t):
    l, r, d = map(int, input().split())

    if (d < l):
        print(d)
        #stdout.write(str(d))
        #stdout.write("\n")
    else:
        print(d * (r//d + 1))
        #stdout.write(str(d * (r//d + 1)))
        #stdout.write("\n")
