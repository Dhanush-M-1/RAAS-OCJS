def main():
    n = int(input())
    d = list(map(int, input()))
    
    count = d.count(8)
    print(0 if count == 0 or n < 11 else min(count, n//11))

if __name__ == "__main__":
    main()
