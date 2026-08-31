no = int(input())

n = []

for i in range(0,no):
    n.append(int(input()))
    
for i in range(0,no):
    k = 0
    br = 0
    while True:
        if n[i] < 6 and n[i] != 3:
            if n[i] == 1:
                print(k)
                break
            elif n[i] == 2 or n[i] == 4 or n[i] == 5:
                print(-1)
                break
        else:
            if n[i] % 6 == 0:
                n[i] = n[i]/6
                k += 1
                br = 0
            else:
                if br == 1:
                    print(-1)
                    break
                n[i] = n[i]*2
                k += 1
                br = 1