from sys import stdin, stdout

n = int(stdin.readline())
lev = stdin.readline()

res = 'no'
for first_i in range(n-4):
    if lev[first_i] == '*':
        max_step = int((n-1-first_i)/4)
        for step_i in range(1,max_step+1):
            res = 'yes'
            for i in range(1,5):
                if lev[first_i+step_i*i] != '*':
                    res = 'no'
                    break
            if res == 'yes':
                break
        if res == 'yes':
            break

stdout.write(res)