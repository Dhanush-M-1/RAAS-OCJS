from fractions import gcd

def solve():
    a, b, c, d = map(int, input().split(' '))
    if a < b or d < b: return False
    if c >= b: return True
    
    a = a % b
    d = d % b
    x = gcd(b, d)
    k = (b - a) // x
    if (b - a) % x == 0: k -= 1
    return not (c < a + k * x < b)
    
def main():
    t = int(input())
    ans = []
    for _ in range(t):
        ans.append(['No','Yes'][solve()])
    for a in ans:
        print(a)

if __name__ == '__main__':
    main()
