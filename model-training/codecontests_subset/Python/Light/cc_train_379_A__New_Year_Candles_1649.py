def main():
    a, b = [int(v) for v in input().split()]
    d = 0
    l = a
    o = 0
    while True:
        if l==0 and o<b:
            break
        d+=1
        l -=1
        o+=1
        if o==b:
            l+=1
            o = 0
    print(d)


if __name__ == "__main__":
    main()
