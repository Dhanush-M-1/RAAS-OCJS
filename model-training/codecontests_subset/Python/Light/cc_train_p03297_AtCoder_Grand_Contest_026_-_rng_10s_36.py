def gcd(a, b):
    if a == 0: return b
    else : return gcd(b % a, a)

def solve():
    a, b, c, d = map(int, input().split())
    if d < b:return "No"
    if a < b:return "No"
    if c >= b:return "Yes"
    g = gcd(d, b)
    a %= b
    if((c-a) // g != (b-a-1) // g):return "No"
    else: return "Yes"


for _ in range(int(input())):
    print (solve())