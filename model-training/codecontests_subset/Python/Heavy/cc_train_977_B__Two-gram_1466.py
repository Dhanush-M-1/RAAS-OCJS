if __name__=='__main__':
    n = int(input())
    s = input()

    apps = {}

    pr = ""

    m = 0
    mk = ""

    for ch in s:
        if pr != "":
            if pr + ch in apps.keys():
                apps[pr + ch] += 1
                if apps[pr + ch] > m:
                    mk = pr + ch
                    m = apps[pr + ch]
            else:
                apps[pr + ch] = 1
                if apps[pr + ch] > m:
                    mk = pr + ch
                    m = apps[pr + ch]
        pr = ch

    print(mk)