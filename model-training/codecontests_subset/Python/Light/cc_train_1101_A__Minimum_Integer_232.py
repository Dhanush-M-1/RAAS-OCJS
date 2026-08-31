q = int(input())
for i in range(q):
    s = input().split()
    l, r, d = int(s[0]), int(s[1]), int(s[2])
    if d<l:
        print(d)
        continue
    u = r - (r%d) + d 
    print(u)