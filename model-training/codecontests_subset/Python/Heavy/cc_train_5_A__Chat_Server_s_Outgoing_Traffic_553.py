import sys

'''
'+mike\n'
'''
users = []
ans = 0

for line in sys.stdin:
    line = line.rstrip()
    # print(f'line= {line}  len= {len(line)}')
    if line[0] == '+':
        users.append(line[1:])
    elif line[0] == '-':
        # ind = users.index(line[1:])
        # del users[ind]
        users.remove(line[1:])
    else:
        '''
                 0123456789
          line= "Mike:hello"
          msg = 4
        '''
        colonInd = line.index(':')
        msg = line[colonInd + 1:]
        ans += len(msg) * len(users)

print(ans)

'''
press (ctrl + d)  in order to stop input
'''
