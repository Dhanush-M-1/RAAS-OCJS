m = list(map(int,input().split()))
a = [list(map(int,input().split())) for i in range(m[0])]
c = [list(map(int,input().split())) for i in range(m[1])]

for i in range(m[0]):
    p=[]
    for j in range(m[1]):
      p.append( abs( a[i][0]-c[j][0])+ abs( a[i][1]-c[j][1]) )
    print(p.index(min(p))+1 )

