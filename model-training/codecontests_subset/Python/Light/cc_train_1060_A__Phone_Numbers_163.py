def solve(n, s):
    n = int(n)
    s = list(map(int, s))
    l = len(list(filter(lambda r: r==8, s)))
    return min(l, len(s)//11)

if __name__=='__main__':
    n = int(input())
    s = input()
    print(solve(n, s))