t = [["a","f","k","p","u","z"],["b","g","l","q","v","."],["c","h","m","r","w","?"],["d","i","n","s","x","!"],["e","j","o","t","y"," "]]

while 1:
    try:
        s = input()
        ans = ""
        i = 0
        l = len(s)
        
        if l % 2 == 0:
            while i < l:
                i1 = int(s[i + 1]) - 1
                i2 = int(s[i]) - 1
                if (i1 >= 0 and i1 <= 4) and (i2 >= 0 and i2 <= 5):
                    ans += t[i1][i2]
                else:
                    break
                i += 2
        if len(ans) * 2 != l:
            ans = "NA"
        print(ans)
    except:
        break
