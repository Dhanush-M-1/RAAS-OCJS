import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    b.sort()
    answer = []
    tmp = [None] * n
    for i in range(n):
        x = (b[0] - a[i]) % m  # b[0]とa[i]が一致するようにxを決める
        for idx in range(n):
            tmp[idx] = (a[idx] + x) % m
        tmp.sort()
        if tmp == b:
            answer.append(x)
    print(min(answer))
    return


if __name__ == '__main__':
    main()
