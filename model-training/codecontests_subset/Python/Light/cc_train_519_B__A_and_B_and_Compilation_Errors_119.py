from collections import Counter

if __name__ == '__main__':
    n = int(input().strip())
    arr = [int(__) for __ in input().strip().split()]
    co = Counter(arr)
    for _ in range(2):
        a = [int(__) for __ in input().strip().split()]
        c = Counter(a)
        for x in co:
            if x not in c or c[x] != co[x]:
                print(x)
                break
        co = c
