n , w, p = map(int,input().split())
import math
rq = math.ceil((p/100)*n)
print(rq-w) if rq-w>0 else print(0)
