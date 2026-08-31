
def main():
    d = int(input())
    c = input()
    ec = len([v for v in c if v=='8'])
    mv = 0
    for i in range(ec+1):
        ne = (len(c) - i) // 10
        mv = max(min(ne, i), mv)

    print(mv)





if __name__ == "__main__":
    main()
