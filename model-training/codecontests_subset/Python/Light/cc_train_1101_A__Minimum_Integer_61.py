q = int(input())
s = 0
for i in range(0,q):
    e = list(map(int,input().split()))
    s = e[2]
    if (s>=e[0]) and (s<=e[1]):
        print(s + e[1] - e[1] % s)
    else:
        print(s)