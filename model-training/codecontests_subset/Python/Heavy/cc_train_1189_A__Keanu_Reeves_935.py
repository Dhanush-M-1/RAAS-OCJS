n = int(input())
s = input()

def check(a):
    for i in range(len(a)):
        t = a[i]
        n0 = 0
        n1 = 0
        for j in range(len(t)):
            if t[j] == "1":
                n1 += 1
            else:
                n0 += 1
        if n0 == n1:
            return False   
    return True

def cut(prev, s, a):
    if a == 1:
        if (check(prev + [s])):
            print(len(prev + [s]))
            print(*prev, s)
            raise SystemExit
        return
    for i in range(len(s)-a+1):
        cut(prev+[s[:i+1]], s[i+1:], a-1)

for i in range(1, n+1):
    cut([], s, i)