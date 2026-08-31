
for i in range(int(input())):
    s, c = [i for i in input().split()]    
    arr = sorted(range(0, len(s)) , key = s.__getitem__)
    s = [i for i in s]
    swap = None
    for i in range(len(s)):
        if i!=arr[i]:
            swap = i
            break
    
    if swap != None:
        lt = s[arr[swap]]
        pos = arr[swap]
        for i in range(len(s)):
            if s[i]==lt:
                pos = i

        s[swap], s[pos] = s[pos], s[swap]
    
    s = ''.join(s)
    if s<c:
        print(s)
    else:
        print('---')