def calc(n,k):
    while n[0] == '0' and len(n)>1:
        n=n[1:]
    
    digit = len(n)
    if digit < k:
        return 0
    
    comb = [1]*(k+1)
    for i in range(1,k+1):
        comb[i] = comb[i-1] * (digit-i) //i
    if k==1:
        return 9*comb[1] + int(n[0])
    elif k==2:
        return (9**2)*comb[2] + (int(n[0])-1) * 9*comb[1] + calc(n[1:],1)
    elif k==3:
        return (9**3)*comb[3] + (int(n[0])-1) * (9**2) * comb[2] + calc(n[1:],2)

n=input()
k=int(input())
print(calc(n,k))