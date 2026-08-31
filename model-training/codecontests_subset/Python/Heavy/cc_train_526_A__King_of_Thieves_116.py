from sys import stderr

n = int(input())
level = input().strip()

good = False

max_jump_size = (n - 5) // 4

for jump_len in range(max_jump_size + 1):
    for startIdx in range(n - 4 - jump_len*4):
        for i in range(5):
            if level[startIdx + i*jump_len + i] == ".":
                #print("startIdx: {} jump_len: {} i: {}".format(startIdx, jump_len, i), file=stderr)
                break
        else:
            good = True
        if good:
            break
    if good:
        break

print("yes" if good else "no")
