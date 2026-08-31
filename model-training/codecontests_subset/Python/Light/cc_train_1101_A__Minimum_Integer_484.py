

def main():
    q = int(input())
    for i in range(q):
        l, r, d = map(int, input().split())
        print(d if d < l else (r // d + 1) * d)


if __name__ == "__main__":
    main()