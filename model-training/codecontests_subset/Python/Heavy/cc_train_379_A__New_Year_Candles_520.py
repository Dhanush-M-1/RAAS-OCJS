"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
"""""""""""""""""""""""""""""""""""""""""""""
#inp = open("lepus.in", "r"); input = inp.readline; out = open("lepus.out", "w"); print = out.write
TN = 1


# ===========================================

  
def solution():
    a, b = map(int, input().split())
    cur_a = a
    cur_b = 0
    ans = 0
    while cur_a>=cur_b:
        ans += cur_a
        cur_b += cur_a
        cur_a = cur_b//b
        cur_b = cur_b%b
    ans += cur_a
    cur_b += cur_a
    cur_a = cur_b//b
    cur_b = cur_b%b
    print(ans+cur_a)


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
#inp.close()
#out.close()