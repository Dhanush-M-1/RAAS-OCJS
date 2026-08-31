s,k=list(map(int,input().split()))
po=list(map(int,input().split()))
po.sort(reverse=True)
for item in po:
    if k%item==0:
        print(int(k/item))
        break
    else:
        pass