import math
N = int(input())
for i in range(N):
  A,B,C,D = map(int,input().split())
  if A<B: #初期の在庫が足りないならダメ
    print("No")
    continue
  if B>D: #消費のほうが大きいならダメ。
    print("No")
    continue
  if A%B > C: #一回目の補給が間に合うか。
    print("No")
    continue
  cycle = D-B
  GCD = math.gcd(B,cycle)
  #print(GCD)
  if GCD == 1 and B-1 > C:
    print("No")
    continue
  if B-GCD > C:
    print("No")
    continue
  print("Yes")
    
    