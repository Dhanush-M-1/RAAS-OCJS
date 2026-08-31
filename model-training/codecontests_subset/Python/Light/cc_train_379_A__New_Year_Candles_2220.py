a, b = list(map(int, input().split()))
res = a
off = a
while off >= b:
    on, off =  divmod(off, b)
    res += on
    off += on
print(res)