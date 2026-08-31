n = int(input())
ans = []
for i in range(n):
     ans.append(list(map(int , input().split())))
for i in ans:
     ans1 = i[-1]
     if ans1 >= i[0] and ans1 <= i[1]:
          bagh = i[1] % ans1
          print((ans1 - bagh) + i[1])
     else:
          print(ans1)
