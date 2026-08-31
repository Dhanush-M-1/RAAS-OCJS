n = int(input()); trg = False
s = ['free', 'free', 'spectate']

for i in range(n):
    r = int(input())
    if r == 1 and s[1] == 'free' and s[2] == 'spectate':
        s[1] = 'spectate'; s[2] = 'free'
    elif r == 1 and s[1] == 'spectate' and s[2] == 'free':
        s[1] = 'free'; s[2] = 'spectate'
    elif r == 2 and s[0] == 'free' and s[2] == 'spectate':
        s[0] = 'spectate'; s[2] = 'free'
    elif r == 2 and s[0] == 'spectate' and s[2] == 'free':
        s[0] = 'free'; s[2] = 'spectate'
    elif r == 3 and s[0] == 'free' and s[1] == 'spectate':
        s[0] = 'spectate'; s[1] = 'free'
    elif r == 3 and s[0] == 'spectate' and s[1] == 'free':
        s[0] = 'free'; s[1] = 'spectate'
    else:
        trg = True; break

print('YNEOS'[trg::2])
