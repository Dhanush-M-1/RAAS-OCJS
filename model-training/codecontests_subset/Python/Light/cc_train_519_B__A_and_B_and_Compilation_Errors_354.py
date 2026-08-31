from sys import stdin
e = [[int(y) for y in x.rstrip().split()] for x in stdin.readlines()][1:]
for x in range(len(e)-1):
    print (sum(e[x])-sum(e[x+1]))