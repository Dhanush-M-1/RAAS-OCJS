password = input()

n = int(input())

kash_words_list = []
for i in range(n):
    kash_words = input()
    kash_words_list.append(kash_words)
    
for a in kash_words_list:
     for b in kash_words_list:
         if password in a+b:
                 print("YES")
                 exit(0)
print("NO")
                 
  		 				    	    	 		  		  	