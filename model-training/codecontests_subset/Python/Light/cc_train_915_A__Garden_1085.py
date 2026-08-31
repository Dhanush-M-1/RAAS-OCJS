n, m = map(int, input().split())
for i in sorted(list(map(int, input().split())), reverse = True):
    if m % i == 0:
        print(m//i)
        exit()