t = int(input())
for _ in range(t):
    Dict = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0,
            'n': 0,
            'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    n, m = [int(i) for i in input().split()]
    s = input()
    p = [int(i) for i in input().split()]
    m1 = max(p)
    d = [0]*n
    for i in p:
        d[i-1] += 1
    for i in range(len(d)-2,-1,-1):
        d[i] += d[i+1]
    for i in range(n):
        Dict[s[i]] += (d[i]+1)
    keys = list(Dict.keys())
    for i in range(len(keys)-1):
        print(Dict[keys[i]], end=" ")
    print(Dict[keys[-1]])
