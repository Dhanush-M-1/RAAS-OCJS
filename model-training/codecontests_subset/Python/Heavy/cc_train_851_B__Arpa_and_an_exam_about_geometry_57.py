import math
a_1,a_2,b_1,b_2,c_1,c_2 = map(int,input().split())
dist_1 = (a_1-b_1)**2 + (a_2-b_2)**2
dist_2 = (a_1-c_1)**2 + (a_2-c_2)**2
dist_3 = (b_1-c_1)**2 + (b_2 - c_2)**2
def checkTriangle(x1, y1, x2, y2, x3, y3): 
      
    # Calculation the area of  
    # triangle. We have skipped  
    # multiplication with 0.5  
    # to avoid floating point  
    # computations  
    a = (x1 * (y2 - y3) +
         x2 * (y3 - y1) + 
         x3 * (y1 - y2)) 
    if a == 0:
      return True
    else:
      return False
def type(sqa,sqb,sqc): 
      
    if (sqa == sqa + sqb or
        sqb == sqa + sqc or
        sqc == sqa + sqb): 
        return True 
  
    elif(sqa > sqc + sqb or
            sqb > sqa + sqc or
            sqc > sqa + sqb):
      return True 
         
  
    else: 
        return False
  


if checkTriangle(a_1,a_2,b_1,b_2,c_1,c_2)== True:
  print("No")
elif dist_1 == dist_3:
  print("Yes")
else:
  print("No")
