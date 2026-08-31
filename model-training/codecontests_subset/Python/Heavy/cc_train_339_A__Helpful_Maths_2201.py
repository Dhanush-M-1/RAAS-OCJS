"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
"""""""""""""""""""""""""""""""""""""""""""""
#inp = open("spaceship.in", "r"); input = inp.readline; out = open("spaceship.out", "w"); print = out.write
TN = 1


# ===========================================
  
  
def solution():
    s = list(input().split("+"))
    s = sorted(s)
    print("+".join(s))


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
#inp.close()
#out.close()