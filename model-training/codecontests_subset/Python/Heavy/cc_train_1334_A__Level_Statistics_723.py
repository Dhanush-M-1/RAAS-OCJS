

def check_validity(p: list, c: list, n: int)-> str:
    if c[0] > p[0]:
        return "NO"
    sum_p, sum_c = p[0], c[0]
    for i in range(1, n):
        if p[i] < sum_p or c[i] < sum_c:
            return "NO"
        elif c[i] > p[i]:
            return "NO"
        elif c[i] - sum_c > p[i] - sum_p and (c[i] - sum_c != 0) :
            return "NO"
        sum_p = p[i]
        sum_c = c[i]
    return "YES"



def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        p, c = [], []
        for _ in range(n):
            pi, ni = list(map(int, input().split()))
            p.append(pi)
            c.append(ni)
        res = check_validity(p, c, n)
        print(res)


if __name__=='__main__':
    main()