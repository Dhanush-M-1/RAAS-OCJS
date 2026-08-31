n = int(input())

line0 = sorted(list(map(int, input().split())))
line1 = sorted(list(map(int, input().split())))
line2 = sorted(list(map(int, input().split())))

done = False
for i in range(len(line0) - 1):
    if line0[i] != line1[i]:
        print(line0[i])
        done = True
        break

if done == False:
    print(line0[-1])

done = False
for i in range(len(line1) - 1):
    if line1[i] != line2[i]:
        print(line1[i])
        done = True
        break

if done == False:
    print(line1[-1])
