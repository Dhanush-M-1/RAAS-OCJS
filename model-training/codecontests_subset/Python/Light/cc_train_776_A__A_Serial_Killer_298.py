ls=input().split();
for i in range(int(input())): 
    v=input().split()
    print(*ls)
    ls.remove(v[0]); ls.append(v[1])
print(*ls)
