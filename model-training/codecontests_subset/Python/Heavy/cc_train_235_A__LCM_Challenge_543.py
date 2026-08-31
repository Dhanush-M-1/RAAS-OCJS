def gcd(a,b):
    while(b > 0):
        temp = a % b
        a = b
        b = temp
    return a
from operator import itemgetter
#int(input())
#map(int,input().split())
#[list(map(int,input().split())) for i in range(q)]
#print("YES" * ans + "NO" * (1-ans))
n = int(input())
if n == 1:
    print(1)
elif n == 2:
    print(2)
elif n % 2 == 1:
    print(n * (n-1) * (n-2))
else:
    num = [0]*6
    temp = n * (n-1)
    temp2 = (n-1) * (n-2)
    num[0] = temp * (n-2) // gcd(temp,n-2)
    num[1] = temp * (n-3) // gcd(temp,n-3)
    num[2] = temp * (n-4) // gcd(temp,n-4)
    num[3] = (n-1) * (n-2) * (n-3)
    num[4] = temp * (n-5) // gcd(temp,n-5)
    num[5] = temp * (n-6) // gcd(temp,n-6)
    print(max(num))
