t = int(input())
for i in range(t):
    a,b,c = [int(item) for item in input().split()]
    result = 0
    if(b==0):
        result = 0
    else:
        # B NÃO É NULO
        totalC = c//2
        if(b<=totalC):
            result+=b
            result+=b*2
            b = 0
        else:
            if(c>=2):
                result+=totalC
                result+=totalC*2
                b-=totalC
                c-=2*totalC
        if(b>=2):
            totalB = b//2
            if(totalB>0):
                if(b>=2 and a>0):
                    if(a>=totalB):
                        result+=totalB 
                        result+=totalB*2
                    else:
                        result+=a
                        result+=a*2

    print(result)