from sys import stdin
n = int(stdin.readline())
a = list(list(j for j in i) for i in stdin.readline().split())
b = list(0 for i in range(0, 10))


for i in a:
    b[len(i) - 1] += 1

Ans = 0




def left(x, b):
    Sum = 0
    y = len(x)
    for i in range(0, 10):
        
        if b[i] == 0:
            continue
        
        X = x.copy()
        for j in range(0, i + 1):
            if y - j >= 0:
                X.insert(y - j, '0')
            else:
                break
            
       
        Sum += int("".join(X)) * b[i]
        
    return(Sum)


def right(x, b):
    Sum = 0
    y = len(x)
    for i in range(0, 10):
        
        if b[i] == 0:
            continue
        
        X = x.copy()
        for j in range(0, i + 1):
            if y - j - 1>= 0:
                X.insert(y - j - 1, '0')
            else:
                break
        
        Sum += int("".join(X)) * b[i]
        
    return(Sum)

for x in a:
    Ans += left(x, b)
    Ans += right(x, b)
    


print(Ans % 998244353)
