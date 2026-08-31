def  bin_s(el, m, a):
    if a[0]>el:
        return 0;
    if a[m-1]<=el:
        return m;
    left = 0; right = m;
    while left+1!=right:
        mid = (left + right)//2
        if a[mid]>el:
            right = mid
        if a[mid]<=el:
            left = mid
    return right

t = int(input())
st = 'abcdefghijklmnopqrstuvwxyz'
for q in range(t):
    n, m = map(int, input().split())
    s = input()
    p = [(int(s)) for s in input().split()]
    ABC = [0] * 27
    p.sort()
    for i in range(0, n):
        ABC[ord(s[i])%26] += (m - bin_s(i, m, p) + 1)
    for i in st:
        print(ABC[ord(i) % 26], end=' ')
    print()
