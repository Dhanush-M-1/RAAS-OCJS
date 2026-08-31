

"""
NTC here
"""
import sys
input= sys.stdin.readline
flush= sys.stdout.flush
# import threading
# sys.setrecursionlimit(10**6)
# threading.stack_size(2**26)

def iin(): return int(input())
def lin(): return list(map(int, input().split()))

def factors(a):
    fact = []
    if a % 2 == 0:
        ch = 0
        while a % 2 == 0:
            ch += 1
            a //= 2
        fact.append(pow(2, ch))
    i = 3
    while i*i <= a:
        if a % i == 0:
            ch = 0
            while a % i == 0:
                ch += 1
                a //= i
            fact.append(pow(i, ch))
        i += 2
    if a > 1:
        fact.append(pow(a, 1))
    return fact
    
def main():
    from math import gcd
    gcd = gcd
    x = iin()
    a, b= 1, x
    i = 1
    while i*i<=x:
        if x%i ==0:
            m,n = i, x//i
            ch1 = gcd(m,n)
            if ch1 ==1:
                if max(a, b)>max(m, n):
                    a, b= m, n
        i+=1
    print(a, b)


main()

#threading.Thread(target=main).start()

