# n = int(input())
# arr = list(map(int,input().split()))
# k,d = map(int,input().split())
# n = int(input())
import sys
import math

def gcd(a,b):
    if(b==0):
        return a
    else:
        return gcd(b,a%b)


def fun():
    # T = int(input())
    # for i in range(T):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    sum1 = sum2 = 0
    for i in range(int(n/2)):
        sum1 += abs(arr[i]-(i*2+1))
        sum2 += abs(arr[i]-(i*2+2))
    print(min(sum1, sum2))

if __name__ == "__main__":
    # print(res(1,3,1))
    fun()

# print(str)
