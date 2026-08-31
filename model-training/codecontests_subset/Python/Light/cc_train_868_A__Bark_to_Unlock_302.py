# IAWT
pas = input()
n = int(input())
ws = [input() for i in range(n)]
def f():
    for i in range(n):
        for j in range(n):
            if pas in ws[i] + ws[j]:
                print('YES')
                return
    print('NO')
    return
f()
