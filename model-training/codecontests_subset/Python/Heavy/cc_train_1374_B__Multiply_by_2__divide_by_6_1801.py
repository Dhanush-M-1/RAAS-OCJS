from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def sinput(): return input()
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################

t = iinput()
while t:
    t-=1
    n = iinput()
    a, b = 0, 0
    while n%6==0:
        n//=6
        a+=1
    while n%3==0:
        n//=3
        b+=1
    print(a+2*b if n==1 else -1)
