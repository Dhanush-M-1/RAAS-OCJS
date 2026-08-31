if __name__ == '__main__':
    a, b = input().strip('\n\r\t ').split(' ')
    a = int(a)
    b = int(b)
    
    avail = a
    burned = 0
    count = 0
    
    while avail > 0:
        count += 1
        avail -= 1
        burned += 1
        
        tmp = burned // b
        avail += tmp
        burned -= tmp * b

    print(count)