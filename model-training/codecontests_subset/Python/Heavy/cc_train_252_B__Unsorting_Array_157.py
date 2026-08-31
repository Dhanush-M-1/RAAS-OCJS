def list_comp(x, y):
    for i in range(0, len(x)):
        if (x[i] != y[i]):
            return False
    return True

def main():

    n = int(input())

    a = list(map(int, input().split(' ')))

    if n <= 2:
        print(-1)
        exit()
    b = a.copy()
    b.sort()
    c = a.copy()
    c.sort(reverse = True)

    for i in range(1, n):
        if a[i] != a[i-1]:
            a[i], a[i-1] = a[i-1], a[i]
            if list_comp(a, b) or list_comp(a, c):
                a[i], a[i-1] = a[i-1], a[i]
            else:
                print(i, i+1)
                exit()
    print(-1)

if __name__ == '__main__':
    main()