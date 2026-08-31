temparr = input()
temparr = temparr.split()
n = int(temparr[0])
minimum = int(temparr[1])
common = []
alice = []
bob = []
for i in range(n):
    temparr = input()
    temparr = temparr.split()
    t = int(temparr[0])
    a = int(temparr[1])
    b = int(temparr[2])
    if a == 1 and b == 1:
        common.append(t)
        continue 
    if a == 1 :
        alice.append(t)
    if b == 1 :
        bob.append(t)
common = sorted(common)
alice = sorted(alice)
bob = sorted(bob)
counta = 0 
countb = 0 
commonlen = len(common)
alicelen = len(alice)
boblen = len(bob)
i = 0 
j = 0 
k = 0 
flag = 0 
ans = 0 
# print(alice)
# print(bob)
# print(common)
if  commonlen + alicelen < minimum or commonlen + boblen < minimum:
    print(-1)
else:
    
    while True:
        
        if counta >= minimum and countb >= minimum:
            print(ans)
            break
        if i == commonlen and j == alicelen and k == boblen:
            flag = 1 
            break
        
        if j == alicelen or k == boblen:
            ans += common[i]
            countb += 1 
            counta += 1 
            i += 1 
            
        elif i == commonlen:
            counta += 1 
            countb += 1 
            ans += alice[j]
            ans += bob[k]
            j += 1 
            k += 1 
        elif common[i] <= alice[j] + bob[k]:
            ans += common[i]
            i += 1 
            counta += 1 
            countb += 1 
        else:
            counta += 1 
            countb += 1 
            ans += alice[j]
            ans += bob[k]
            j += 1 
            k += 1 
            
    
    if flag == 1:
        print(-1)
    
    
    
    
    
    
    




