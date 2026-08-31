def main():
    n, k = list(map(int, input().split()))
    b = list(map(int, input().split()))
    b.sort(reverse=True)
    for num in b:
        if k % num == 0:
            print(k // num)
            return
main()