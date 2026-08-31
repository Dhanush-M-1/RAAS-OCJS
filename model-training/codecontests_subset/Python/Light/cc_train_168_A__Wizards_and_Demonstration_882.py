P, N , rate = map(int,input().split())

need = P * rate / 100
if (P * rate) % 100 == 0:
    need = P * rate // 100
else:
    need = P * rate // 100 + 1
    
if need > N:
    print(need - N)
else:
    print(0)     
