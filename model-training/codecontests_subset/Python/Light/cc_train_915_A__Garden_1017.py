def main():
    n,k = map(int,input().split(" "))
    a = list(map(int,input().split(" ")))
    total = 101
    for i in a:
        if k%i == 0:
            if k//i <= total:
                total = k//i
    print(total)

main()
