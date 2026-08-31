def main(n, m, a, b):
    index = 0
    l = [1]
    while index < n:
        if a[index] in b:
            l.append(a[index])
            print('YES')
            print(*l)
            return
        index = index + 1
    print('NO')
    
    
if __name__ == '__main__':
    t = int(input())
    for t_itr in range(t):
        nm = list(map(int, input().rstrip().split()))
        n = nm[0]
        m = nm[1]
        a = list(map(int, input().rstrip().split()))
        b = list(map(int, input().rstrip().split()))
        res = main(n, m, a, b)
