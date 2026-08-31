"""
Codeforces Contest 307 Div 2 Problem B

Author  : chaotic_iak
Language: Python 3.4.2
"""

################################################### SOLUTION

def main():
    a = read(0)
    b = read(0)
    c = read(0)
    s = [0]*26
    for i in a: s[ord(i)-97] += 1
    t = s[:]
    x = [0]*26
    for i in b: x[ord(i)-97] += 1
    y = [0]*26
    for i in c: y[ord(i)-97] += 1
    best = (0, 0)
    curr = 0
    while True:
        m = min((s[i]//y[i] if y[i] != 0 else 10**18) for i in range(26))
        if curr+m > best[0]: best = (curr+m, curr)
        flag = False
        for i in range(26):
            s[i] -= x[i]
            if s[i] < 0: flag = True
        curr += 1
        if flag: break
    for i in range(best[1]):
        write(b)
        for i in range(26): t[i] -= x[i]
    for i in range(best[0]-best[1]):
        write(c)
        for i in range(26): t[i] -= y[i]
    for i in range(26): write(chr(97+i)*t[i])




#################################################### HELPERS



def read(mode=2):
    # 0: String
    # 1: List of strings
    # 2: List of integers
    inputs = input().strip()
    if mode == 0: return inputs
    if mode == 1: return inputs.split()
    if mode == 2: return list(map(int, inputs.split()))

def write(s="\n"):
    if s is None: s = ""
    if isinstance(s, list): s = " ".join(map(str, s))
    s = str(s)
    print(s, end="")

write(main())