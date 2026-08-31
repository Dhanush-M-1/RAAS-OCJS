def solve_case():
    n = int(input())
    inp = list(tuple(map(int, input().split())) for _ in range(n))
    a, b = inp[0]
    for ai, bi in inp:
        if ai < bi:
            return "NO"
        if ai < a:
            return "NO"
        if bi < b:
            return "NO"
        da = ai - a
        db = bi - b
        if db > da:
            return "NO"
        a, b = ai, bi
    return "YES"

def main():
    tests = int(input())
    for t in range(1, tests + 1):
        print(solve_case())

if __name__ == '__main__':
    main()
