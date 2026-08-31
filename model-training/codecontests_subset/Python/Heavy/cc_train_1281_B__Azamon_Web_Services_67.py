from sys import stdin,stdout

def main():
    T = int(stdin.readline())
    for i in range (T):
        a = list(map(str,stdin.readline().split()))
        newstr = str(a[0])
        already = False
        possible = False
        for j,(x,y) in enumerate(zip(a[0],a[1])):
            if x < y:
                possible = True
                break
            if x >= y and already is False:
                k = len(a[0]) - 1
                while k > j:
                    if a[0][k] < a[1][j]:
                        temp = list(newstr)
                        temp[j],temp[k] = temp[k],temp[j]
                        newstr = "".join(temp)
                        already = True
                        possible = True
                        break
                    k -= 1
                if already is False and x > y:
                    k = len(a[0]) - 1 
                    while k > j:
                        if a[0][k] == a[1][j] and a[0][k]!= a[0][j]:
                            temp = list(newstr)
                            temp[j],temp[k] = temp[k],temp[j]
                            newstr = "".join(temp)
                            already = True
                            possible = True
                            break
                        k -= 1
                if k == j and x > y:
                    possible = False
                    break
                elif k == j and x == y:
                    continue
                else:
                    break
            if possible is True or already is True:
                break
        if newstr < a[1]:
            stdout.write(newstr+"\n")
        else:
            stdout.write("---\n")
            
main()