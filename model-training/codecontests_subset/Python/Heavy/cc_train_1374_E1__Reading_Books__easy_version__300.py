n, k = map(int, input().split())

both = []
alice = []
bob = []
for i in range(n):
    t, a, b = map(int, input().split())

    if a and b:
        both.append(t)
    elif a:
        alice.append(t)
    elif b:
        bob.append(t)

alice.sort(reverse=True)
bob.sort(reverse=True)
both.sort(reverse=True)

def solve():
    ak = k
    bk = k
    v = 0

    while ak > 0 and bk > 0:
        if (not alice or not bob) and not both:
            return -1
        
        if alice and bob and (not both or both[-1] > alice[-1] + bob[-1]):
            v += alice.pop() + bob.pop()
        else:
            v += both.pop()

        #print(alice, bob, both, ak,bk, v)
        ak -= 1
        bk -= 1
        
    while ak > 0:
        if not alice and not both:
            return -1
        
        if alice and (not both or both[-1] > alice[-1]):
            v += alice.pop()
        else:
            v += both.pop()

        #print(alice, bob, both, ak, bk, v)
        ak -= 1

    while bk > 0:
        if not bob and not both:
            return -1

        if bob and (not both or both[-1] > bob[-1]):
            v += bob.pop()
        else:
            v += both.pop()

        bk -= 1

        #print(alice, bob, ak, bk, v)

    return v

print(solve())




