for _ in range(int(input())):
    s = input()
    s = [s[i] for i in range(len(s))]
    if len(s) == 1:
        print(0)
        continue
    if len(s) == 2:
        if s==s[::-1]:
            print(1)
            continue 
    for i in range(1,len(s)-1):
        if s[i+1] == s[i-1]and s[i-1] == s[i]:
            s[i+1] = "?"
            s[i] = "?"
        elif s[i-1] == s[i]:
            if s[i-1] == "?":
                i+=1
                continue
            s[i] = "?"
        elif s[i+1] == s[i-1]:
            s[i+1] = "?"
        elif s[i] == s[i+1]:
            s[i+1] = "?"
    print(s.count("?"))