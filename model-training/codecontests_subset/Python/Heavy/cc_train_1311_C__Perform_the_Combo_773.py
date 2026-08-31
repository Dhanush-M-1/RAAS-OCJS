from sys import *
t=int(input())
while t>0:
    d={'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    n,m=list(map(int,stdin.readline().split()))
    s=stdin.readline()
    p=list(map(int,stdin.readline().split()))
    p.sort()
    q=0
    j=0
    for i in p:
        for _ in range(i-q):
            d[s[j]]+=m+1
            j+=1
        q=i
        m-=1
    while j<n:
        d[s[j]]+=1
        j+=1
    print(*(list(d.values())))
    t-=1
