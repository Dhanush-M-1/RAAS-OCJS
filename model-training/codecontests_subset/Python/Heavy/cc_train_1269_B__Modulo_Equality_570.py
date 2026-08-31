n, m = [int(x) for x in input().split()]

a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

a = sorted(a)
b = sorted(b)

#wow = list(set(a+b))
moves = set()
bb = list(set(b))
aa = list(set(a))
for ii in range(len(aa)):
    for x in [(bb[i]-aa[ii])%m for i in range(len(bb))]:
        moves.add(x)

#moves = list(moves
#print(moves)
#exit()
pastmv = 0
ans = m+5
b = b
#print(b)
for mvv in moves:
    mv = pastmv + mvv
    #pastmv = mv
    aa = sorted([(x+mv)%m for x in a])
    #print([(x+mv)%m for x in a], mv)

    fl = aa==b#True
    #for i, j in zip(aa, b):
     #   fl = fl and (i == j)
      #  if i != j:
       #     break
    if fl:
        ans = min(ans, mv)
        break

if ans != m+5:
    print(ans)
else:
    raise NotImplemented()

