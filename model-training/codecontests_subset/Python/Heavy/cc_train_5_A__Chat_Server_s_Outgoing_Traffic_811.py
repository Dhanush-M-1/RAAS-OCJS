import sys

'''
in order to quit : ctrl + d
'''
users = []
ans = 0

for line in sys.stdin:
    # print("line = {}".format(line))
    #print(f'line = {line}')
    line = line.rstrip()
    #print("line = {}  line length = {}".format(line, len(line)))
    if line[0] == '+':
        #add user e.x. line = '+Mike'  user add 'Mike'  without '+' sign
        users.append(line[1:])
    elif line[0] == '-':
        #remove element from users list
        users.remove(line[1:])
    else:
        # do work
        ans += len(line[line.index(':')+1:]) * len(users)
print(ans)
