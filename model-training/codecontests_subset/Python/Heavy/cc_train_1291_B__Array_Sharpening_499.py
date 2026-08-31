import sys, math

def input():
    return sys.stdin.readline()[:-1]

def main():
    q = int(input())
    for _ in range(q):
        n = int(input())
        a = list(map(int,input().split()))
        f = -1
        ans = 0
        for k in range(n):
            if a[k] < k:
                f = k
                break
        if f == -1:
            ans = 1
        else:
            a = a[::-1]
            ans = 1
            for k in range(n-f+1):
                if a[k] < k:
                    ans = 0
                    break
        if ans == 1:
            print("Yes")
        else:
            print("No")

if __name__ == '__main__':
    main()
