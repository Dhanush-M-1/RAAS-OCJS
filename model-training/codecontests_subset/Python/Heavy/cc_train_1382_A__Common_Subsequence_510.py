def sol(a, b):
    nlst = []
    if sorted(a) == sorted(b):
        print("YES")
        print(1, a[-1])
        return

    for i in a:
        if i in b:
            nlst.append(i)
    if len(nlst) == 0:
        print("NO")
        return
    else:
        print("YES")
        print(1, nlst[0])
        return

if __name__ == '__main__':
    for _ in range(int(input())):
        n, m = map(int, input().split())
        a = list(map(int, input().split()))
        b = list(map(int, input().split()))
        sol(a, b)