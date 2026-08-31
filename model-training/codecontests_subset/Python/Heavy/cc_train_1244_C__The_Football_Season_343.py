# Contest: Codeforces Round #592 (Div. 2) (https://codeforces.com/contest/1244)
# Problem: C: The Football Season (https://codeforces.com/contest/1244/problem/C)

def rint():
    return int(input())


def rints():
    return list(map(int, input().split()))


n, p, w, d = rints()
for i in range(w):
    if d * i > p:
        break
    if d * i % w == p % w:
        wi = (p - d * i) // w
        if wi + i > n:
            print(-1)
        else:
            print(wi, i, n - wi - i)
        exit(0)
print(-1)
