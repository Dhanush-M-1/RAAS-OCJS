"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
"""""""""""""""""""""""""""""""""""""""""""""
#inp = open("lepus.in", "r"); input = inp.readline; out = open("lepus.out", "w"); print = out.write
TN = int(input())


# ===========================================

  
def solution():
    l, r, d = map(int, input().split())
    if d < l: print(d)
    elif d > r: print(d)
    elif l <= d <= r:
        print((r//d+1)*d)


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
#inp.close()
#out.close()