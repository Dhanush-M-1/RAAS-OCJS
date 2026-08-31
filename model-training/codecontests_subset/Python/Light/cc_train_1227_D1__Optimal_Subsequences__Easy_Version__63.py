def main():
    import os
    from io import BytesIO
    input = BytesIO(os.read(0, os.fstat(0).st_size)).readline
    n = int(input())
    a = [(int(el), -ind) for ind, el in enumerate(input().split())]
    a.sort(reverse=True)
    for i in range(int(input())):
        x, y = map(int, input().split())
        t = sorted(a[:x], key=lambda x: -x[1])
        print(t[y - 1][0])

main()
