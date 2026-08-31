n = int(input())
nabor = str(input())
#print(len(nabor))
if len(nabor) < 11:    
    print(0)
elif(nabor.count("8") >= (n // 11)):
    print(n // 11)
elif(nabor.count("8") < n //11 and nabor.count("8") > 0):
    print(int(nabor.count("8")))
else:
    print(0)
