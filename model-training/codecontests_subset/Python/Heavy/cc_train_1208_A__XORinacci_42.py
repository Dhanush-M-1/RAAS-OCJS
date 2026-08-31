import sys
input = sys.stdin.readline

def getInt(): return int(input())
def getVars(): return map(int, input().split())
def getArr(): return list(map(int, input().split()))
def getStr(): return input().strip()
## -------------------------------

t = getInt()
for _ in range(t):
    a, b, n = getVars()
    a2 = bin(a)[2:]
    b2 = bin(b)[2:]
    
    m = max(len(a2), len(b2))
    a2 = '0'*(m-len(a2)) + a2
    b2 = '0'*(m-len(b2)) + b2
    s = ''
    for i in range(m):
        if a2[i] == '0' and b2[i] == '0':
            s += '0'
        else:
            ost = n % 3
            if ost == 0:
                s +=a2[i]
            if ost == 1:
                s += b2[i]
            if ost == 2:
                s += str((int(a2[i]) + int(b2[i])) % 2)
    print(int(s, base = 2))
                
