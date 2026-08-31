n,k = map(int, input().split())
ali = list()
bob = list()
both = list()
for i in range(n):
    l = list(map(int, input().split()))
    if l[1] == 1 and l[2] == 1:
        both.append(l[0])
    elif l[1] == 1:
        ali.append(l[0])
    elif l[2] == 1:
        bob.append(l[0])
ali.sort(reverse=True)
bob.sort(reverse=True)
both.sort(reverse=True)


a = len(ali)
b = len(bob)
if a > b:
    a = b
bt = len(both)
if a + bt < k:
    print(-1)
else:
    count = 0
    i,j =-1, -1
    a, bt = -a, -bt

    while i>=a and j>=bt and k>0:
        #print(i,j)
        if ali[i] + bob[i] < both[j]:
            count += ali[i] + bob[i]
            k -= 1
            i -= 1
            
        else:
            count += both[j]
            j -= 1
            k -= 1
    if j<bt:
        while i>=a and k>0:
            count += ali[i] + bob[i]
            k -= 1
            i -= 1
            
    else:
        while j>=bt and k >0:
            count += both[j]
            j -= 1
            k -= 1
        
    print(count)
            
        
