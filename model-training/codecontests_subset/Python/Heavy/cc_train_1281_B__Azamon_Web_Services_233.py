
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s,c = input().split()
        idx = {}
        for i, cc in enumerate(list(s)):
            idx[cc] = i
        si = sorted(s)
        for i in range(len(s)):
            if si[i] != s[i]:
                sl = list(s)
                sl[i],sl[idx[si[i]]] = sl[idx[si[i]]], sl[i]
                s = "".join(sl)
                break
        # print(s,c)
        if s < c:
            print(s)
        else:
            print("---")
        