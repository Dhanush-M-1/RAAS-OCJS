t =  int(input())
for _ in range(t) :
    a, b, c = map(int, input().split())
    sum = 0
    if 2*b < c :
        sum += b + 2*b
    else :
        if c %2 == 0 :
            sum += c
            sum += c//2
            b = b - c//2
        else :
            sum += (c-1)
            sum += (c-1)//2
            b = b - (c-1)//2
        if 2*a < b :
            sum += (a + 2*a)
        else :
            if b%2 == 0 :
                sum += b
                sum += b//2
            else :
                sum += (b-1)
                sum += (b-1)//2
    print(sum)
    
        
