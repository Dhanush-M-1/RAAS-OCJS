import string


def main():
    letters = string.ascii_lowercase
    n, m = map(int, input().split())
    line = input()
    p = list(map(int, input().split()))
    dct = dict()
    for i in range(1, len(line) + 1):
        dct[i] = 0
    for i in p:
        if i in dct:
            dct[i] += 1
        else:
            dct[i] = 1
    rng = sorted(dct)
    to_add = 0
    letdct = dict()
    for i in letters:
        letdct[i] = 0
    for i in range(len(rng) - 1, -1, -1):
        to_add += dct[rng[i]]
        letdct[line[rng[i] - 1]] += to_add
    for i in line:
        letdct[i] += 1
    for i in letters:
        print(letdct[i], end=" ")
    print()



if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        main()
