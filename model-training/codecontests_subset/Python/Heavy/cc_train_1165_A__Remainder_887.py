from sys import stdin

def read_lines(sep=' ', input_type=None):
    #list of rows
    _lines = stdin.readlines()
    cast = input_type is not None
    lines = []
    for line in _lines:
        line = line[:-1].split(sep)
        if cast:
            line = [input_type(x) for x in line]
        lines.append(line)
    return lines

import collections

if __name__ == '__main__':

    lines = read_lines(input_type=None)
    
    n,x,y = [int(z) for z in lines[0]]
    
    num = lines[1][0]
    
    num = num[-x:]
    
    counter = 0
    for v in num:
        if v!='0':
            counter+=1
            
    if num[-y-1]=='0':
        counter+=1
    else:
        counter-=1
        
    print(counter)