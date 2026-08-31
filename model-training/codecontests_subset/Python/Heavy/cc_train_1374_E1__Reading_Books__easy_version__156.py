
initial = input().strip().split(' ')
books = int(initial[0])
likes = int(initial[1])

alice_list = []
bob_list = []
both_list = []
for i in range(books):
    line_input = input().strip().split(' ')
    time = int(line_input[0])
    alice = (int(line_input[1]) == 1)
    bob = (int(line_input[2]) == 1)
    
    if alice and bob:
        both_list.append(time)
    elif alice:
        alice_list.append(time)
    elif bob:
        bob_list.append(time)

alice_list.sort()
bob_list.sort()
length = min(len(alice_list), len(bob_list))
separate_list = []
for i in range(length):
    separate_list.append(alice_list[i] + bob_list[i])

total_list = both_list + separate_list

if len(total_list) < likes:
    print(-1)
else:
    total_list.sort()
    total = 0
    for r in range(likes):
        total += total_list[r]
    print(total)
