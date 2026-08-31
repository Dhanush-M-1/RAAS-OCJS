import sys
input = sys.stdin.readline

def li():return [int(i) for i in input().rstrip('\n').split()]
def val():return int(input().rstrip('\n'))


for _ in range(val()):
    n,l,r = li()
    orig = r
    l -= 1
    r -= l


    currleft = 0
    curs = n - 1
    while curs and currleft + 2*curs <= l:
        currleft += 2*curs
        curs -= 1
    
    start = n - curs
    ans = []
    head = start
    l -= currleft

    last = head + 1
    half = 0
    while l:
        half = 1
        start = last
        last += 1
        l -= 1
        if not l:break
        half = 0
        start = head
        l -= 1

    if half:
        ans.append(start)
        if last == n + 1:
            head += 1
            last = head + 1
        start = head
        r -= 1

    while r:
        ans.append(start)
        r -= 1
        if not r:break
        start = last
        ans.append(start)
        last += 1
        if last == n + 1:
            head += 1
            last = head + 1
        r -= 1
        start = head
    
    if orig == n*(n-1) + 1:
        ans[-1] = 1

    print(*ans)