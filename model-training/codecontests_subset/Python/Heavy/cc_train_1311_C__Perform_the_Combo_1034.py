#1311C
ls = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
t = int(input())
for ___ in range(t):
    dc = {'a': 0, 'c': 0, 'b': 0, 'e': 0, 'd': 0, 'g': 0, 'f': 0, 'i': 0, 'h': 0, 'k': 0, 'j': 0, 'm': 0, 'l': 0, 'o': 0, 'n': 0, 'q': 0, 'p': 0, 's': 0, 'r': 0, 'u': 0, 't': 0, 'w': 0, 'v': 0, 'y': 0, 'x': 0, 'z': 0}
    a, b =  map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    p = sorted(p)
    k=1
    b-=1
    for j in range(b, 0, -1):
        for i in range(p[j-1], p[j]):
            dc[s[i]]+=k
        k+=1
    for i in range(0, p[0]):
        dc[s[i]]+=k
    for i in range(a):
        dc[s[i]]+=1
    ss = str()
    for el in ls:
        ss+=str(dc[el])+' '
    print(ss)
