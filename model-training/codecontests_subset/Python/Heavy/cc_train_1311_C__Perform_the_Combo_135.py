for _ in range(int(input())):
    n,m = map(int,input().split())
    s = input()
    pressed = []
    for i in range(26):
        cnt = 0
        keys = []
        for j in range(n):
            if ord(s[j])-ord('a') == i:
                cnt+=1
            keys.append(cnt)
        pressed.append(keys)
    ps = list( map( lambda x: int(x)-1, input().split() ) )
    counts = [0]*26
    for p in ps:
        for i in range(26):
            counts[i] += pressed[i][p]
    for i in range(26):
        counts[i] += pressed[i][-1]
    print(*counts)