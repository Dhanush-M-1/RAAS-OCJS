n = int(input())
l = list(map(int, input().split()))
chet = 0
nechet = 0
sum_chet = 0
sum_nechet = 0
l_chet = []
l_nechet = []
for i in l:
    if i % 2 == 0:
        chet+=1
        sum_chet+=i
        l_chet.append(i)
    else:
        nechet+=1
        sum_nechet+=i
        l_nechet.append(i)
l_chet.sort()
l_nechet.sort()
if chet == nechet or chet - 1 == nechet or nechet - 1 == chet:
    print(0)
else:
    if chet > nechet:
        print(sum(l_chet[:chet-nechet - 1]))
    else:
        print(sum(l_nechet[:nechet-chet - 1]))