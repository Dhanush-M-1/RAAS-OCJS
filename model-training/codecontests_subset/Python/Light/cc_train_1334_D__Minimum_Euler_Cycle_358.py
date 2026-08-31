t = int(input())

for _ in range(t):
    n, l, r = map(int, input().split())
    l -= 1
    r -= 1
    
    start_i = 1
    pos = 0
    while start_i < n:
        cur_i_len = 2 * (n-start_i)
        if pos + cur_i_len > l:
            break
        pos += cur_i_len
        start_i += 1
        
    wanted_len = r-l+1
    
    s = []
    
    while len(s) < l-pos+wanted_len:
        if start_i < n:
            for i in range(start_i+1, n+1):
                s += [str(start_i), str(i)]
        else:
            s += ["1"]
        start_i += 1
    
    print(*s[l-pos:l-pos+wanted_len])
