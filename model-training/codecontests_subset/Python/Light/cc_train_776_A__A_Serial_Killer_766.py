def main():
    from sys import stdin
    a, b = stdin.readline().split(); n = int(stdin.readline().rstrip()); print(a, b)
    for i in range(n):
        k, s = stdin.readline().split()
        if a == k: a = s
        else: b = s
        print(a, b)
main()