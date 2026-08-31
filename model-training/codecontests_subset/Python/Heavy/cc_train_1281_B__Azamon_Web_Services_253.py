def swap(s):
    l = len(s)
    index = list(range(l))
    index.sort(key=lambda i:s[i])
    low = None
    for i in range(l):
        ind = index[i]
        if s[i] != s[ind]:
            left = i
            low = s[ind]
            break
    if low is None:
        return
    right = 0
    for i in range(l):
        if s[i] == low:
            right = i
    s[left], s[right] = s[right],s[left]



def f():
    s, c = [list(str) for str in input().split()]
    if s < c:
        print(''.join(s))
        return
    swap(s)
    if s < c:
        print(''.join(s))
    else:
        print('---')

t = int(input())
for i in range(t):
    f()