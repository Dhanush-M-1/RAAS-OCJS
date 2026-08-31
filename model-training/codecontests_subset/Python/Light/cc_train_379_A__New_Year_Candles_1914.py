

if __name__ == '__main__':
    a,b = map(int, input().split())
    c = h = 0
    for i in range(a):
        h += 1
        c += 1
        if c == b:
            h += 1
            c = 1
    print(h)