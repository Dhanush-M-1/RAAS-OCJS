t = int(input())
for __ in range(t):
    a, b = input().split()
    a = [c for c in a]
    c_idx = [-1]*26
    for i, c in enumerate(a):
        c_ord = ord(c) - ord('A')
        c_idx[c_ord] = max(i, c_idx[c_ord])

    allowed = True
    for i, c in enumerate(a):
        c_ord = ord(c) - ord('A')
        if not allowed:
            break
        for j in range(26):
            if allowed and j < c_ord and c_idx[j] > i:
                a[c_idx[j]], a[i] = a[i], a[c_idx[j]]
                allowed = False
                break
    a = ''.join(a)
    if a < b:
        print(a)
    else:
        print('---')

