


def message(numbers):
    numbers=str(numbers)
    message=""
    while(len(numbers)>0):
        num=numbers[:2]
        if len(num)==1:
            return "NA"
        if int(num[0])>6 or int(num[0])<=0:
            return "NA"
        if int(num[1])>5 or int(num[1])<=0:
            return "NA"
        code=(int(num[0])-1)*5+int(num[1])
        if code>30:
            return "NA"
        if code==27:
            message+="."
        elif code==28:
            message+="?"
        elif code==29:
            message+="!"
        elif code==30:
            message+=" "
        else:
            message+=chr(code-1+ord('a'))
        numbers=numbers[2::]
    return message


while True:
    try:
        n=input()
        print(message(n))
    except EOFError:
        break

