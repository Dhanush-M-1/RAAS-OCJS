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
    
    t = lines[0]
    #lines = lines[1:]
    
    string = lines[1][0]
    counter = collections.defaultdict(int)
    
    maxtgram=None
    maxappear=0

    length = len(string)
    for i,char in enumerate(string):
        if i < length - 1:
            tgram = string[i:i+2]
            counter[tgram]+=1
            v=counter[tgram]
            
            if v > maxappear:
                maxappear=v
                maxtgram=tgram
                
    print(maxtgram)
            
            
    