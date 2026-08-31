"""""""""""""""""""""""""""""""""""""""""""""
|    author: mr.math - Hakimov Rahimjon     |
|    e-mail: mr.math0777@gmail.com          |
"""""""""""""""""""""""""""""""""""""""""""""
#inp = open("lepus.in", "r"); input = inp.readline; out = open("lepus.out", "w"); print = out.write
TN = 1


# ===========================================

  
def solution():
    n = int(input())
    a = list(map(int, input().split()))
    sm = sum(a)
    even = []
    odd = []
    for i in range(n):
        if a[i]%2: odd.append(a[i])
        else: even.append(a[i])
    even = sorted(even)
    odd = sorted(odd)
    l_ev = len(even)
    l_od = len(odd)
    if abs(l_ev-l_od)<2: ans = 0
    else:
        ans = 0
        if l_ev>l_od:
            for i in range(l_ev-l_od-1):
                ans += even[i]
        else:
            for i in range(-l_ev+l_od-1):
                ans += odd[i]
    print(ans)


# ===========================================
while TN != 0:
    solution()
    TN -= 1
# ===========================================
#inp.close()
#out.close()