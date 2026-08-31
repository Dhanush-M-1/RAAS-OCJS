N = int(input())
def calc(n, L, ma):
    if n == 0: 
        print("".join([chr(a+97) for a in L]))
        return L
    for i in range(ma+2):
        l = calc(n-1, L + [i], max(ma, i))

calc(N, [], -1)