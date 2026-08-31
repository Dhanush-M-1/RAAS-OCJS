init = input()
print(init)
init = init.split()
t = int(input())
for x in range(t):
    
    init+=input().split()
    for y in init:
        if init.count(y)==2:
            init.remove(y)
            init.remove(y)
    print(*init)