def substring_rearrange(s):
    dup = sorted(s)
    if list(s) == dup:
        return "NO"
    else:
        i = 0
        s = list(s)
        start = ""
        while i < len(s):
            if dup[i] != s[i]:
                start = i + 1
                ref = dup[i]
                break
            else:
                i += 1
        search = lambda x,y,start : [j+1 for (d,j) in zip(y,range(len(y))) if d == x and j > start-1]
        end = search(ref,s,start)[0]
        


            
    
        return "YES\n" + str(start) + " " +  str(end)


n = int(input())

print (substring_rearrange(input()))
                
                
            

    
        


          
          
          
     
