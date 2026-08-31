def main():
    str = input()
    am1 = am2 = am3 = 0
    for i in str:
        if i == '1':
            am1+=1
        elif i =='2':
            am2+=1
        elif i == '3':
            am3+=1
    str = ''
    while(am1 or am2 or am3):
        if (am1 > 1 or am2 or am3) and am1 :
            str+='1+'
            am1-=1
        elif am1 == 1:
            str+='1'
            am1-=1
        elif (am2 > 1 or am1 or am3) and am2:
            str+='2+'
            am2-=1
        elif am2 == 1:
            str+='2'
            am2-=1
        elif (am3 > 1 or am2 or am1) and am3:
            str+='3+'
            am3-=1
        elif am3 == 1:
            str+='3'
            am3-=1
    print(str)

main()
         

       
