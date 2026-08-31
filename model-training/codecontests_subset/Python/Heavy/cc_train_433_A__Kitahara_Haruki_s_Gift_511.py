def equal_apples (apples):
    two_g = 0
    one_g = 0
    for x in apples :
        if x == '200' :
            two_g += 1
        else:
            one_g += 1

    if two_g%2 == 0 :
        if one_g%2 == 0:
           return "YES"
        else:
            return "NO"
    else:
        if one_g < 2 :
            return "NO"
        else:
            one_g -= 2
            if one_g %2 == 0:
                return "YES"
            else:
                return "NO"
            
       

n = int(input())
apples = input().split()

print (equal_apples(apples))
    
