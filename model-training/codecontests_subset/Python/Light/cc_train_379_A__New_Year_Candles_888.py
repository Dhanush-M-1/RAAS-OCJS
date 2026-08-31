def main():
        a,b = map(int, input().split())
        c = a
        while a//b > 0:
                c += a//b
                a = a//b + a%b
        print(c)


if __name__ == '__main__':
        main()

        