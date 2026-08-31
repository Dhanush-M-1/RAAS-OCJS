def solution():
    a, b = (int(i) for i in input().split(' '))
    c = 0
    i = 0
    while a > 0:
        c += 1
        i += 1
        if i == b:
            a += 1
            i = 0
        a -= 1
    print(c)

if __name__ == "__main__":
    solution()
