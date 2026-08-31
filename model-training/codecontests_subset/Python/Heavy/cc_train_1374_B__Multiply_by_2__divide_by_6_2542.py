import sys
input = sys.stdin.readline

def inp():
    return(int(input()))

def inlist():
    return(list(map(int,input().split())))

def instr():
    s = input()
    return(list(s[:len(s)-1]))

def invr():
    return(map(int,input().split()))

def findth(x,m):
    a = 0
    while(x%m==0):
        a += 1
        x /= m
    return a

def chk(x):
    while(x%3==0):
        x/=3
    while(x%2==0):
        x /= 2
    if(x!=1):
        return 0
    return 1

def main():

    t = inp()

    for l in range(t):

        n = inp()

        t = findth(n,2)
        h = findth(n,3)

        if(n==1):
            print(0)
        elif(h == 0 or t > h or chk(n)==0):
            print(-1)
        else:
            print(2*h-t)


main()