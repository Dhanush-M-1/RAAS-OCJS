import math
import sys

def getinputdata():

    # 配列初期化
    array_result = []
    
    data = input()
    
    array_result.append(data.split(" "))

    flg = 1

    try:
        while flg:

            data = input()

            array_temp = []

            if(data != ""):
                
                array_result.append(data.split(" "))

                flg = 1

            else:

                flg = 0
    finally:


        return array_result

arr_data = getinputdata()
s = arr_data[0][0]

#print(s,s[::-1],s[::-1].translate(str.maketrans('bdpq', 'dbqp')))


print("Yes" if s == s[::-1].translate(str.maketrans('bdpq', 'dbqp')) else "No")