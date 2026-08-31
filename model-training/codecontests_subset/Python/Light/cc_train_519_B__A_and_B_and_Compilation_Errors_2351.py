n = int(input())
s = input()
for i in range(2):
    l1 = s.split()
    s = input()
    l2 = s.split()
    l1.sort()
    l2.sort()
    ok = True
    for j in range(len(l2)):
        if l2[j] != l1[j]:
            print(l1[j])
            ok = False
            break
    if ok == True:
            print(l1[-1])


        
