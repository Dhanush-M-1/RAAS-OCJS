import math
a = int(input())
b = int(input())
# If a > b swap the two
if (a > b): 
    temp = b 
    b = a 
    a = temp  

# I am guaranteed a < b
a_moves = math.ceil((b-a)/2) # how many steps friend 1 has to move
b_moves = math.floor((b-a)/2) # how many steps friend 2 has to move

a_tiredness = 0 
b_tiredness = 0

# Calculate tiredness value of friend 1 
for i in range(0, a_moves):
    a_tiredness += i+1 

# Calculate tiredness value of friend 2 
for j in range(0, b_moves):
    b_tiredness += j+1 
    
print(a_tiredness + b_tiredness)