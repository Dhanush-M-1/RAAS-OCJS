def solution():
    from sys import stdout, stdin
    _input, _print = stdin.readline, stdout.write
    for _ in range(int(_input())):
        n = int(input())
        f = False
        for i in range(n):
            p, c = [int(i) for i in input().split()]
            if i == 0:
                oldp, oldc = p, c
                if p < c:
                    f = True
            else:
                if oldp > p or oldc > c:
                    f = True
                elif p - oldp < c - oldc:
                    f = True
            oldp, oldc = p, c
        if f:
            print("NO")
        else:
            print("YES")
solution()
