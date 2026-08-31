def watermelon():    
    w = int(input())

    if w % 2 == 0:
        print("YES")
    else:
        print("NO")

# watermelon()

def way_too_long_words():
    n = int(input())
    words = [input() for x in range(n)]

    for word in words:
        if len(word) > 10:
            print(f'{word[0]}{len(word)-2}{word[-1]}')
        else:
            print(word)

# way_too_long_words()

def team():
    n = int(input())
    v = [[int(x) for x in input().split()] for i in range(n)]
    o = 0
    for l in v:
        if l.count(1) >= 2:
            o += 1

    print(o)

# team()

def next_round():
    n, k = map(int, input().split())
    s = [int(x) for x in input().split()]
    o = 0
    i = s[k-1]

    for j in s:
        if j >= i and j != 0:
            o += 1
    print(o)

# next_round()


def domino_piling():
    import math
    m,n = map(int, input().split())
    o = 0
    if m * n < 2:
        print(0)
        exit()
    
    if m % 2 == 0:
        o = (m * n) / 2
    elif n % 2 == 0:
        o = (m * n) / 2
    else:
        o = math.floor(m * n / 2)
    
    print(int(o))
    
# domino_piling()


def bitplusplus():
    n = int(input())
    s = [input() for i in range(n)]

    o = 0
    for j in s:
        if '++' in j:
            o +=1
        if '--' in j:
            o -= 1
    print(o)

# bitplusplus()

def petya_and_strings():
    a = input().lower()
    b = input().lower()

    c = [a,b]
    c.sort()
    
    if a == b:
        print(0)
    elif b == c[0]:
        print(1)
    elif a == c[0]:
        print(-1)

# petya_and_strings()

def beautiful_matrix():
    for i in range(5):
        r = [int(x) for x in input().split()]
        if 1 in r:
            xmove = abs(r.index(1) - 2)
            ymove = abs(i - 2)
            o = (xmove + ymove)
    print(o)
# beautiful_matrix()

def helpful_maths():
    s = input().split('+')
    s.sort()
    s = '+'.join(s)
    
    print(s)

helpful_maths()