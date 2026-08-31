### Stones ###
### https://codeforces.com/contest/1236/problem/A ###
t = int(input())
kq = []
for i in range(t):
    stone = [int(c) for c in input().split()]
    if stone[1] == 0:
        kq.append(0)
    else:
        c = int(stone[2]/2)
        b = stone[1] - c
        if b < 0:
            kq.append(3*stone[1])
        elif b == 0:
            kq.append(3*c)
        else:
            a = stone[0]-int(b/2)
            if a >= 0:
                kq.append(3*c + 3*int(b/2))
            else:
                kq.append(3*c + 3*stone[0])
for i in range(t):
    print(kq[i])