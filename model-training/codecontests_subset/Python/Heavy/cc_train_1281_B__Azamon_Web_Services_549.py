import re
def posi(A,pat):
    return [a.start() for a in list(re.finditer(pat, A))]

for _ in range(int(input())):
    A, B = input().split(" ")
    C = [*A];D = sorted(C)
    temp1 =0;temp2=0;temp3 =0
    for i in range(len(C)):
        if ord(C[i]) > ord(D[i]):
            temp1 = i
            #print(temp1)
            temp2 = D[i]
            temp3=C[i]
            break
    stri = A
    if temp2 != 0:
        #print(C,D)
        X = posi(A,temp2)
        C[X[-1]],C[temp1] = C[temp1],C[X[-1]]
        stri = ("".join(C))
    if stri <B:
        print(stri)
    else:
        print("---")
            
            
    