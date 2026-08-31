N = int(input())
def mojiOut(s, mx):
    if len(s) == N:
        print(s)
        return

    for i in range(ord("a"), ord(mx) + 2):
        strS = s
        strS += chr(i)
        mojiOut(strS, max(mx, chr(i)))

mojiOut("a",  "a")