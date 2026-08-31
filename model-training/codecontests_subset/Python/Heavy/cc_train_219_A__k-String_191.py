import operator
k=int(input())
s=str(input())
# j=[s.count(i) for i in s]
# l=dict([i for i in s],[s.count(i) for i in s])
d = {i:s.count(i) for i in s}
# print(list(d))

sorted_x = sorted(d.items(), key=operator.itemgetter(1),reverse=1)
mo=""
for i,j in sorted_x:
        ajout = ""
    # mo+=str(i*int(()))
    # print(i,j)
    # mo=mo.rjust(int(j/k), i)
    # print(int(j/k))
        if j%k!=0:
            print("-1")
            exit(0)
        else:
            ajout=ajout.rjust(int(j/k), i)
            mo+=ajout
# print(sorted_x,mo)
# mo=mo.rjust(len(s),mo)
empty=""
for z in range(k):
    empty+=mo

print(empty)