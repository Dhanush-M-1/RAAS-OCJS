from sys import stdin

def solve(moments, n):
    if not (moments[0][0]>=moments[0][1]): return False
    for i in range(1, n):
        if not (moments[i][0]>=moments[i-1][0] and moments[i][1]>=moments[i-1][1] and ((moments[i][1]-moments[i-1][1]) <= (moments[i][0]-moments[i-1][0]))): return False
    return True

def main():
    r = stdin.readline
    cases = int(r())
    for case in range(cases):
        attempts = list()
        n = int(r())
        for i in range(n): attempts.append(tuple(map(int, r().strip().split())))
        print("YES" if solve(attempts, n) else "NO")
main()