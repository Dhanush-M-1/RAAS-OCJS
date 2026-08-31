def nb_occ(ss,s):
    i = 0
    res = 0
    while (i < len(s) - 1):
        if (s[i] + s[i+1] == ss):
            res +=1
        i+= 1
    return res

def peterpartout(s,taille):
    if (taille == 0 or taille == 1):
        return "koto"
    else:
        d = {}
        i = 1
        res = s[0]+s[1]
        resocc = nb_occ(res,s)
        while (i < taille - 1):
            tmp = s[i] + s[i+1]
            if(not (tmp in d)):
                nbocctmp = nb_occ(tmp,s[i:])
                if(nbocctmp > resocc):
                    res = tmp
                    resocc = nbocctmp
                d[tmp] = 1
            i+=1
        return res
n = int(input())
s = input()
print(peterpartout(s,n))
