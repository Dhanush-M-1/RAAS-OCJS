import math

n, k, p = map(int, input().split())

need = math.ceil(n*p/100)

res = need-k

print( res if res>0 else 0 )