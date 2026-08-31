from sys import stdin
import math


def main():    
    lon = int(stdin.readline().strip())
    string = stdin.readline().strip()
    if string.count('1')!=string.count('0'):
        print(1)
        print(string)
    else:
        print(2)
        print(string[0:lon-1],string[lon-1])
        
    """i =  1;
    while i<=lon:
        tmp = math.ceil(lon/i)
        subStr = []
        isP = 1
        j = 0
        #print(tmp)
        while j < lon:    
            #print(j,tmp)
            cad = string[j:j+tmp]
        #    print(cad)
            if(cad.count('1') != cad.count('0')):
                  subStr.append(cad)
            else:           
                isP = 0
                break
            j+=tmp
        #print(subStr)
        if isP:
            break
        i+=1
    """
   
main()

