def gcd(a, b) :
    if a == 0 :
        return [b, 0, 1]
    res = gcd(b%a, a)
    return [res[0], res[2] - b//a * res[1], res[1]]


def get_any(a, b, p) :
    nod = gcd(a, b)
    if p % nod[0] != 0:
        return []
    mul = p//nod[0];
    return [nod[0], nod[1] * mul, nod[2] * mul]

inp = input().split()
n = int(inp[0])
p = int(inp[1])
w = int(inp[2])
d = int(inp[3])

result = get_any(w, d, p)

if(len(result) == 0) :
    print(-1)
else :
    g = int(result[0])
    x = int(result[1])
    y = int(result[2])
    
    add_x = d//g
    add_y = w//g
    
    if y < 0 :
        k = (-y + add_y - 1)//add_y;
        x = x - k * add_x
        y = y + k * add_y
    k = y//add_y
    x = x + k * add_x
    y = y - k * add_y
    if x < 0 or x + y > n :
        print(-1)
    else :
        print("{} {} {}".format(int(x), int(y), int(n - x - y)))
