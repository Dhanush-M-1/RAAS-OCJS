itype = int
def inp(): return int(input())
def tinput(): return list(map(itype, input().split(" ")))


cr = []


def solve(a, si):
    if(a == []):
        return
    global cr
    root = a.index(max(a))
    for i in range(len(a)):
        if i != root:
            cr[i+si] += 1
    solve(a[:root], si)
    solve(a[root+1:], root+1+si)


output = []
for tc in range(int(input())):
    n = inp()
    a = tinput()
    cr = [0]*n
    solve(a, 0)
    output.append(" ".join(list(map(str, cr))))

print('\n'.join(output))
