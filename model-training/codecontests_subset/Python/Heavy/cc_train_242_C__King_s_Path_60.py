x , y , u , v = map(int,input().split())

n = int(input())
rows = set()
for i in range(n):
    r , a , b = map(int , input().split())
    rows.update((r , x) for x in range(a , b + 1))

nxt , visited , cnt = [(x , y)] , {(x ,y)} , 0
flag = True
while (nxt):
    cur , nxt = nxt , []
    for x , y in cur:
        if (x == u and y == v):
            print(cnt)
            exit()

        for xy in (x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1), (x - 1, y - 1), (x + 1, y - 1), (x - 1, y + 1),\
                  ( x + 1, y + 1):
            #print(xy)
            if xy in rows and xy not in visited:
                visited.add(xy)
                nxt.append(xy)

    cnt +=1


print('-1')