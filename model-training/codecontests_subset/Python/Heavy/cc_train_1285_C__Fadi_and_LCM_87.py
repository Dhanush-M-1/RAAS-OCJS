#Tuan_Kkura

def get_bit(val, id) :
    return (val >> id)&1

X = int(input())

tmp = X
val = []
for i in range(2, 1000001) :
    num = 1
    while X%i == 0 :
        X /= i
        num *= i
    if num > 1 : val.append(num)
if X > 1 : val.append(X)
#print(*val[0:])
resA = 10**12; resB = 10**12
n = len(val)
for state in range(0, (1<<n)) :
    A = 1; B = 1
    for i in range(0, n) :
        if get_bit(state, i) == 0 :
            A *= val[i]
        else : B *= val[i]
    if max(A, B) < max(resA, resB) :
        resA = A; resB = B
print(int(resA), int(resB))


