n = int(input().strip())

tries = []
for _ in range(3):
    tries.append(sum(map(int, input().strip().split())))
    
print(tries[0] - tries[1], tries[1] - tries[2], sep='\n')
