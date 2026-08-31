n = int(input())
ls = list(map(int, input().split()))
lt = list(map(int, input().split()))
lu = list(map(int, input().split()))
ls.sort()
lt.sort()
lu.sort()

for i in range(len(lt)):
    if lt[i] != ls[i]:
        print(ls[i])
        break
    if i == len(lt)-1:
        print(ls[-1])


for i in range(len(lu)):
    if lu[i] != lt[i]:
        print(lt[i])
        break
    if i == len(lu)-1:
        print(lt[-1])