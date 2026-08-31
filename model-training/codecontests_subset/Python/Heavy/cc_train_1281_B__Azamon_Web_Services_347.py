n = int(input())

def swap(s, i, j):
    lst = list(s)
    lst[i], lst[j] = lst[j], lst[i]
    return ''.join(lst)

def indexr(ls, x):
    for i in range(len(ls)):
        if(ls[len(ls)-1-i]==x):
            return len(ls)-1-i
            break
    else:
        return -1

def ttt(s, t):
    if(len(s)<len(t) and t[0:len(s)]==s):
        return True
    else:
        for k in range(min(len(s),len(t))):
            if(ord(s[k])>ord(t[k])):
                return False
            elif(ord(s[k])<ord(t[k])):
                return True
    return False


for i in range(n):
    test = input().split()
    a = test[0]
    b = test[1]
    for k in range(min(len(a),len(b))):
        if(ord(a[k])<ord(b[k])):
            print(a)
            break
        else:
            l = min(a[k:], key=ord)
            ind = indexr(a[k:], l)
            ls = swap(a, ind+k, k)
            if(ttt(ls, b)):
                print(ls)
                break
            if(a[k]!=b[k]):
                print("---")
                break

    else:
        print("---")

