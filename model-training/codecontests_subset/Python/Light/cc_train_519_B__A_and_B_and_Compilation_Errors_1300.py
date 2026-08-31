n = int(input())
a1 = list(map(int, input().split()))
a2 = list(map(int, input().split()))
a3 = list(map(int, input().split()))

a1.sort()
a2.sort()
a3.sort()

for i in range(len(a2)):
    if a1[i] !=a2[i]:
        print(a1[i])
        break
    elif a2[i] ==a2[-1]:
        print(a1[-1])
        break

for i in range(len(a3)):
    if a2[i] !=a3[i]:
        print(a2[i])
        break
    elif a3[i] ==a3[-1]:
        print(a2[-1])
        break
