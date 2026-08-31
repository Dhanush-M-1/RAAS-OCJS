def main():
    n, k = map(int, input().split())
    a, b, both = [], [], []
    for i in range(n):
        nt, na, nb = map(int, input().split())
        if na == nb == 1:
            both.append(nt)
        elif na == 1 and nb == 0:
            a.append(nt)
        elif na == 0 and nb == 1:
            b.append(nt)
    a.sort(); b.sort()
    for i in range(min(len(a), len(b))):
        both.append(a[i] + b[i])
    both.sort()
    if len(both) < k:
        print(-1)
    else:
        print(sum(both[:k]))
    
            
        

# for _ in range(int(input())):
#     main()
main()