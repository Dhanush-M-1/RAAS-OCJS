from sys import exit
n = int(input())
letters_prev = [None for i in range(30)]
letters_fow = [None for i in range(30)]

okk = [False for i in range(30)]

for i in range(n):
    task = [ord(i) - ord('a') for i in input()]

    if len(task) == 1: okk[task[0]] = True

    for i in range(1, len(task)):
        if (letters_prev[task[i]] is not None and  letters_prev[task[i]] != task[i-1]) or task[i] == task[i-1]:
            print('NO')
            exit()
        else:
            letters_prev[task[i]] = task[i-1]

    for i in range(len(task)-1):
            if (letters_fow[task[i]] is not None and  letters_fow[task[i]] != task[i+1]) or task[i] == task[i+1]:
                print('NO')
                exit()
            else:
                letters_fow[task[i]] = task[i+1]

    # print(task, letters_prev, letters_fow)
def chain_p(x, was=[]):
    global letters_fow, letters_prev
    if x is None: return []
    if letters_prev[x] is None:
        return [x]
    else:
        if letters_prev[x] in was:
            print('NO')
            exit()
        ans = chain_p(letters_prev[x], was=was+[letters_prev[x]]) + [x]
        # letters_prev[x] = None
        return ans

def chain_f(x, was=[]):

    global letters_fow, letters_prev
    # print('_f', x, letters_fow[x])
    if x is None: return []
    if letters_fow[x] is None:
        # letters_fow[x] = None
        return [x]
    else:
        if letters_fow[x] in was:
            print('NO')
            exit()
        ans = chain_f(letters_fow[x], was=was+[letters_fow[x]]) + [x]
        # letters_fow[x] = None
        return ans

done = []
cc = []
while True:
    flag = False

    for i in range(30):
        if i in done: continue
        prev = []
        post = []

        if letters_prev[i] is not None:
            flag = True
            prev = chain_p(letters_prev[i])

        if letters_fow[i] is not None:
            flag = True
            post = chain_f(letters_fow[i])

        done.extend(prev)
        done.extend(post)
        done.append(i)

        if len(prev) + len(post) == 0 and okk[i]:
            cc.append(chr(i+ord('a')))
        elif  len(prev) + len(post) > 0:
            cc.append("".join([chr(i+ord('a')) for i in prev] + [chr(i+ord('a'))] + [chr(i+ord('a')) for i in post][::-1]))

    if not flag: break
cc.sort()
print("".join(cc))
