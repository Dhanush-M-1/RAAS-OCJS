def main_function():
    t = int(input())
    for test_case in range(t):
        n = int(input())
        p, c = list(map(int, input().split()))
        flag = True
        if c > p:
            flag = False
        for i in range(n - 1):
            new_p, new_c = list(map(int, input().split()))
            if new_p < p or new_c < c or new_c > new_p or new_c - c > new_p - p:
                flag = False
            p, c = new_p, new_c
        print('YES' if flag else 'NO')


if __name__ == '__main__':
    main_function()