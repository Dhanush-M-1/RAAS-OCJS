def GCP(a, b):
    #print(a, b)
    if a == 0 or b == 0:
        return(max(a, b))
    elif a > b:
        return GCP(a % b, b)
    else:
        return GCP(b % a, a)
        
def LCM(a, b):
    return ( a // GCP(a, b) ) * b;

n = int(input())

#divs = []
best_div_1 = '1'
best_div_2 = str(n)
min_max_div = n
# ищем делители числа n ;)
div = 1

while div*div <= n:
   
    if n % div == 0:
        #print(max(div, n//div), min_max_div)
        if max(div, n // div) < min_max_div:
            if LCM(div, n//div) == n:
                min_max_div = max(div, n // div)
                best_div_1 = str(min(div, n//div))
                best_div_2 = str(max(div, n//div))
    div += 1
    
print(best_div_1, best_div_2)