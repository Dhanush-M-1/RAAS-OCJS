initial = input().split(" ")
print(initial[0] + " " + initial[1])
numCases = int(input())
for _ in range(numCases):
    
    names = input().split(" ")
    if initial[0] == names[0]:
        initial[0] = names[1]
    else:
        initial[1] = names[1]
    print(initial[0] + " " + initial[1])
