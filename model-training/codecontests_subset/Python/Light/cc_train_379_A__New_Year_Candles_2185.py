def Main():
    a, b = map(int, input().split())

    ans = 0
    while a >= b:
        rem = a%b
        ans += (a - rem)
        a //= b
        a += rem
    
    ans += a

    print(ans)

if __name__ == "__main__":
    Main()
