if __name__ == '__main__':
    n= int(input())
    ss= input()
    numbers= n// 11
    #print('numbers: '+str(numbers))
    count= 0
    while('8' in ss):
        index= ss.index('8')
        ss= ss[:index]+ ss[index+1:]
        count+= 1
        #print('index: '+str(index)+' count: '+str(count)+' ss: '+str(ss))

    print(min(numbers, count))