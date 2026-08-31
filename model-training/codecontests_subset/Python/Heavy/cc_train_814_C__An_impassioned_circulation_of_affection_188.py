import sys


# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

input = sys.stdin.readline


def getCons(string, m, c):
    n = len(string)

    ans = 0
    st, end = 0, 0
    
    while end < n:
        if string[end] == c:
            end += 1
        elif m:
            m -= 1
            end += 1
        else:
            while st < end and string[st] == c:
                st += 1
            st += 1
            m += 1
        ans = max(ans, end-st)

    return ans       
        

t = 1

while t:
    t -= 1

    n = int(input())
    s = input().strip()

    dp = {}


    q = int(input())
    for _ in range(q):
        m, c = input().split()
        if (m, c) in dp:
            print(dp[(m, c)])
            continue

        dp[(m, c)] = getCons(s, int(m), c)
        print(dp[(m, c)])
