from sys import stdin,stdout
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

tc = ii1()
for _ in range(tc):
    n = ii1()
    s = is1()
    if s[0] == '>' or s[-1] == '<':
        print(0)
    else:
        c1 = 0
        for i in s:
            if i == '<':
                c1 += 1
            else:
                break
        c2 = 0
        for i in s[::-1]:
            if i == '>':
                c2 += 1
            else:
                break
        print(min(c1,c2))

    