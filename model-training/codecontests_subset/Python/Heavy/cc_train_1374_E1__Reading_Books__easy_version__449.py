import bisect

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) ]))
def invr():
    return(map(int,input().split()))




l = inlt()

n = l[0]
k = l[1]

alice = []
bob = []
good = []
for i in range(n):
    l = inlt()
    if(l[1] == 1 and l[2] == 1):
        good.append(l)
    elif(l[1] == 1):
        alice.append(l)
    elif(l[2] == 1):
        bob.append(l)

good.sort(key = lambda j:j[0])
alice.sort(key = lambda j:j[0])
bob.sort(key = lambda j:j[0])
a = 0
b = 0
g = 0
total = 0
book = 0
while(book < k):
    if(g < len(good)):
        if(a >= len(alice) or b >= len(bob)):
            total += good[g][0]
            g += 1
        else:
            if(alice[a][0] + bob[b][0] < good[g][0]):
                total += alice[a][0] + bob[b][0]
                a += 1
                b += 1
            else:
                total += good[g][0]
                g += 1
    elif(a < len(alice)  and b < len(bob)):
        total += alice[a][0] + bob[b][0]
        a += 1
        b += 1
    else:
        total = -1
        break
    book += 1

print(total)
