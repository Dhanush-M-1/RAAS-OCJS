def main():
    while True:
        w_num = int(input())
        if w_num == 0: break

        w_list = []
        for i in range(w_num):
            w_list.append(input())

        for i in range(len(w_list)):
            #print(w_list)
            leng = 0
            for item in w_list:
                #print("leng" + str(leng))
                if leng < 5:
                    leng += len(item)
                    if leng > 5:
                        leng = 0
                        break
                elif leng < 12:
                    leng += len(item)
                    if leng > 12:
                        leng = 0
                        break
                elif leng < 17:
                    leng += len(item)
                    if leng > 17:
                        leng = 0
                        break
                elif leng < 24:
                    leng += len(item)
                    if leng > 24:
                        leng = 0
                        break
                else:
                    leng += len(item)
                    if leng > 31:
                        leng = 0
                        break
                    
                if leng == 31:
                    print(i + 1)
                    break
            if leng == 31: break
            del w_list[0]
main()

