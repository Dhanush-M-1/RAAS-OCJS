def p(x):
    return x[0]


n, k = map(int, input().split())
a = []
for i in range(n):
    a.append(list(map(int, input().split())))
a.sort(key=p)
# print()
# print()
# for i in a:
#     print(i)
alice, bob, common = [], [], []
al, bo = 0, 0
flag = 1
for i in a:
    if(i[1] and not i[2]  and al < k):
        alice.append(i[0])
        al += 1
    if(i[2] and (not i[1])  and bo < k):
        bob.append(i[0])
        bo += 1
    if(i[1] and i[2]):

        if(al<k or bo<k):
            common.append(i[0])
            al += 1
            bo += 1
            if(al > k and alice):
                alice.pop()
                al -= 1
            if(bo > k and bob):
                bob.pop()
                bo -= 1
        else:
            if(alice and bob):
                if(alice[-1]+bob[-1] > i[0]):
                    alice.pop()
                    bob.pop()
                    common.append(i[0])
                else:
                    break
    
    # print(alice, bob, common, al, bo)
if(al >= k and bo >= k):
    print(sum(alice)+sum(bob)+sum(common))
else:
    print(-1)
