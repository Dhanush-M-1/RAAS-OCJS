"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
"""""""""""""""""""""""""""""""""""""""""""""
#inp = open("lepus.in", "r"); input = inp.readline; out = open("lepus.out", "w"); print = out.write
TN = int(input())


# ===========================================

  
def solution():
    n = int(input())
    s = list(input())
    ind1 = -1
    ind2 = 0
    cur = 1
    for i in range(n):
        if s[i] == ">" and cur:
            cur = 0
            ind1 = i
        if s[i] == "<": ind2 = i
    print(min(len(s[:ind1]), len(s[ind2+1:])))


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
#inp.close()
#out.close()