def main():
    pwrd = input()
    ww = {input() for _ in range(int(input()))}
    ww = ww | {a[1] + b[0] for a in ww for b in ww}
    print(('NO', 'YES')[pwrd in ww])


if __name__ == '__main__':
    main()
