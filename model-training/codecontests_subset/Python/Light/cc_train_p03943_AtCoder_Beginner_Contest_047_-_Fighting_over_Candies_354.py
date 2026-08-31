l=sorted(list(map(int, input().split())))
print('YNeos'[l[0]+l[1]-l[2]!=0::2])