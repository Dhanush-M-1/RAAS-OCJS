# Codeforces Round #607 divison 2
# Problem: (B) Azamon Web Services
# Status: Accepted

def swap_char(arr, x, y):
    arr = list(arr)
    arr[x], arr[y] = arr[y], arr[x]
    return "".join(arr)

for _ in [0] * int(input()):
    a,b = [x for x in input().split()]
    lens = len(a)
    for i in range(lens - 1):
        curr = a[i + 1]
        poss = -1
        for j in range(i+1, lens):
            if a[j] <= curr:
                poss = j
                curr = a[j]
        if curr < a[i]:
            #print(a)
            a = swap_char(a, poss, i)
            #print(a)
            break
    print(["---", a][a < b])







