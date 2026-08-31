def gcd(a, b):
    while (a != b and a != 0 and b != 0):
        if a > b:
            a = a % b
        else:
            b = b % a
    return max(a, b)

def gcd_ls(ls):
    ls = list(ls)
    while len(ls) > 1:
        #print("test", ls)
        new_ls = []
        for i in range(0, len(ls), 2):
            if i + 1 < len(ls):
                gcd_res = gcd(ls[i], ls[i + 1])
                new_ls.append(gcd_res)
            else:
                new_ls.append(ls[i])
        ls = new_ls
    return ls[0]

        
n = int(input())
ls = list(map(int, input().split()))
mx = max(ls)
deltas = [0] * n
for i in range(n):
    deltas[i] = mx - ls[i]
z = gcd_ls(deltas)
y = sum(deltas) // z
print(y, z)
