def main():
    
    n = int(input())
    word = input()
    wordSearch = word;
    found = True
    dic = {}
    higherNum = 0
    higherKey = ""
    
    for i in range(n-1):
        
        pair = word[i:(i+2)]
        
        if pair not in dic:
            dic[pair] = 0
        else:
            continue
        
        index = 0
        wordSearch = word
        found = True
        
        while found:
            
            index = wordSearch.find(pair)
            
            if(index != -1):
                
                dic[pair] = dic[pair] + 1
                
                if(dic[pair] > higherNum):
                    higherNum = dic[pair]
                    higherKey = pair
                    
                wordSearch = wordSearch[(index+1):len(wordSearch)]
                
            else:
                
                found = False
    
    print(higherKey)
    
main()
	       					   	 			 		 	 			