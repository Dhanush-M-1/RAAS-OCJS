k = int(input())
n = list(map(int,input()))
kv = n.count(8)
print(kv if kv < k // 11 else k//11)