from sys import stdin
#####################################################################
def iinput(): return int(stdin.readline())
def sinput(): return input()
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
#####################################################################
n, m = minput()
a = linput()
b = linput()
b.sort()
x = float('inf')
for e in a:
    temp = (b[0]-e+m)%m
    temp_a = []
    for i in range(n):
        temp_a.append((a[i]+temp)%m)
    temp_a.sort()
    if temp_a == b: x = min(x, temp)
print(x)
