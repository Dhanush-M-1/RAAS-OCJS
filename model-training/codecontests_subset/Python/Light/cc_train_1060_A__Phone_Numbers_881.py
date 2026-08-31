def solve(n, s):
    x = s.count(8)
    m = len(s)//11 
    return min(m, x)



def main():
    n = int(input())
    s = list(map(int, input()))
    print(solve(n, s))


main()
