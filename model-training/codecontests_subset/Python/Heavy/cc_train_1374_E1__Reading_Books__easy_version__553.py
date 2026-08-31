from sys import stdin
import math
[n, k] = [int(j) for j in stdin.readline().split()]

time = 0
common = dict()
alice = dict()
bob = dict()
lencommon = 0
lenalice = 0
lenbob = 0


for i in range(0, n):
    [a, b, c] = [j for j in stdin.readline().split()]
    a = int(a)
    if b == '1' and c == '1':
        lencommon += 1
        if a in common.keys():
            common[a] += 1
        else:
            common[a] = 1
            
    elif b == '1':
        lenalice += 1
        if a in alice.keys():
            alice[a] += 1
        else:
            alice[a] = 1
        
    elif c == '1':
        lenbob += 1
        if a in bob.keys():
            bob[a] += 1
        else:
            bob[a] = 1


if (lencommon + lenalice) < k or (lencommon + lenbob) < k:
    print('-1')
else:

    common[math.inf] = 1
    alice[math.inf] = 1
    bob[math.inf] = 1
    A = min(alice)
    B = min(bob)
    C = min(common)
    for i in range(0, k):
        if A + B < C:
            time += A + B
            alice[A] -= 1
            bob[B] -= 1
            if alice[A] == 0:
                del alice[A]
                A = min(alice)
            if bob[B] == 0:
                del bob[B]
                B = min(bob)
        else:
            time += C
            common[C] -= 1
            if common[C] == 0:
                del common[C]
                C = min(common)
    print(time)
