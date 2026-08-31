#prime_num = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163 ,167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293]
def hcf(a, b):
    if a == 0:
        return b
    
    elif b == 0:
        return a
    
    rem = a%b
#    print(rem)
    
    while rem:
        a, b = b, rem
        rem = a%b
#        print(a, b, rem)
    
    return b

n = int(input())
a = list(map(int, input().split()))

x = max(a)
ans = 0
stolen = []

for left in a:
    stolen.append(x-left)
    ans += stolen[-1]

z = hcf(stolen[0], stolen[1])
for s in stolen:
    z = hcf(z, s)
    
print(ans//z, z)
