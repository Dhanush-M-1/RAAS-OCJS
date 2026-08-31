class Solution:
    
   


    @staticmethod
    def bookreading(pages , firstday , threshold , addingFactor , gobackPages):
        pages_read = firstday
        pages = pages-pages_read
        day = 1
        while pages>0:
            pages = pages+gobackPages
            factor = firstday+day*addingFactor
           
            if factor  <= threshold:
                pages_read = factor
            else:
                pages_read = threshold
            
            pages = pages - pages_read
            
            
            day += 1
        
        return day
        


if __name__ == "__main__":
   
    c, v0, v1, a , l  = map(int , input().split())
    
    days = Solution.bookreading(c, v0, v1, a , l)
    print(days)


        
