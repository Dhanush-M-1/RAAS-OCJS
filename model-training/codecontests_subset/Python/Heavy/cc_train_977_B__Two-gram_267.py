
a = int(input())
word = input()
w = [] # разбиваем word
num = [] # Сколько раз входили элементы word
r = [] # комбинации англ букв
n = None
m = None
p = ""
ind = None
ans = None

for i in range(0, a - 1):
    w.insert(i, word[i] + word[i + 1])

for i in range(65, 91):
    for k in range(65, 91):
        n = chr(i)
        m = chr(k)
        p = n + m
        r.append(p)

for u in range(0, 676):
    num.append(w.count(r[u]))

ind = num.index(max(num))
ans = r[ind]

            


        

    


print(ans)


