n = int(input())
g = []
for i in range(n):
    g.append(int(input()))

res = 'YES'
st1 = [1, 2, 3]
st2 = [0, 0, 0]
gres = []
gres.append(tuple(st1))
for i in range(n):
    d = g[i]
    st2[0] = d
    st2[1] = st1[2]
    for i in range(1, 4):
        if i!=st2[0] and i!=st2[1]:
            st2[2] = i
    st1 = st2
    gres.append(tuple(st2))

for i in range(len(gres)-1):
    if gres[0][0]==3:
        res = 'NO'
        break
    if gres[i][2]==gres[i+1][0]:
        res = 'NO'
        break


print(res)