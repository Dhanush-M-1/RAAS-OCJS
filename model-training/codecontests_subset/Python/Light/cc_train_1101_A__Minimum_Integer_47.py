def read():
  return int(input())
def reads():
  return [int(x) for x in input().split()]

N=int(input())
table=[]
for i in range(N):
    l,r,d=reads()
    table.append((l,r,d))
for l,r,d in table:
    if d<l:
        print(d)
    else:
        print((r//d + 1)*d)