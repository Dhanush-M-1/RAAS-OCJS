import sys
import math
input = sys.stdin.readline

def int_array():
    return list(map(int, input().strip().split()))


def str_array():
    return input().strip().split()

def lower_letters():
    lowercase = []
    for i in range(97, 97+26):
        lowercase.append(chr(i))
    return lowercase
    
def upper_letters():
    uppercase = []
    for i in range(65, 65+26):
        uppercase.append(chr(i))
    return uppercase

######################## TEMPLATE ENDS HERE ########################

a,b = int_array()
ans, res = 0,0
while a!=0:
    ans += 1
    res += 1
    if res == b:
        res = 0
        a+=1
    a -= 1

print(ans)