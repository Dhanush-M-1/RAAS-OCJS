l = list(map(str,input().split()))
n = int(input())
for i in l:
    print(i, end = " ")
print("")
for i in range(n):
    ll = list(map(str,input().split()))
    
    if(l[0] == ll[0]):
        l[0] = ll[1]
    else:
        l[1] = ll[1]
    
    for j in l:
        print(j, end = " ")
    print('')
