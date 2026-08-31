for t in range(int(input())):
    s, c = input().split()
    s = list(s)
    lowest = sorted(s)
    pos = -1
    for i in range(len(s)):
        if s[i] != lowest[i]:
            pos = i
            break
    if pos == -1:
        string = "".join(s)
        if string < c:
            print(string)
        else:
            print("---")
    else:
        for i in range(len(s)-1,pos,-1):
            if s[i] == lowest[pos]:
                s[pos], s[i] = s[i], s[pos]
                break
        string = "".join(s)
        if string < c:
            print(string)
        else:
            print("---")

