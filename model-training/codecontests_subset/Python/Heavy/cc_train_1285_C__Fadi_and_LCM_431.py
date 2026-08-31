"""
 * @author      : Luis Miguel Baez <es.luismiguelbaez@gmail.com>
 * @created     : August 28, 2020
"""
from sys import stdin
from math import sqrt
 
"""
T=int(stdin.readline().strip())
n=int(stdin.readline().strip())
n,m=map(int,stdin.readline().strip().split())
s=list(map(int,stdin.readline().strip().split()))
s=stdin.readline().strip()
"""
 
def gcd(a, b):
    tmp = 0
    while b > 0:
        tmp = a
        a = b
        b = tmp % b
    return a
 
 
def lcm(a, b): 
    return (a*b)/gcd(a, b);  
 
 
def divisors(n):
    ans = []
    for i in range(1, int(sqrt(n))+1):
        
        if n % i == 0:
            if n//i == i:
                pass
            else:
                if lcm(n//i, i) == n:
                    ans.append((n//i, i))
    return ans
 
def main():
    n=int(stdin.readline().strip())
    if n == 1:
        print(1, 1)
        return
    ans = divisors(n)
 
    if len(ans) > 1:
        ans.sort()
        mini = int(1e18)
        idx = 0
        for i in range(len(ans)):
            if max(ans[i][0], ans[i][1]) < mini:
                mini = max(ans[i][0], ans[i][1])
                idx = i
        print(ans[idx][1], ans[idx][0])
    else:
        print(ans[0][1], ans[0][0])
 
if __name__ == "__main__":
    main()