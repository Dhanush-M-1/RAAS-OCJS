string = input()
lis = []

for i in string:
    if(i!='+'):
        
       lis.append(i)
    
lis.sort()    
d='+'.join( lis )
print(d)
    
         
'''lis.sort()
xx = ( lis[x-1] )
print(xx )
lis[x-1] = str(xx)

#std = sorted( string )
#b = ''.join( std )

print(lis)
b = ''.join(lis)  
print(b )
    
    



# strings are immutable in Python
for i in range( len(b)-1 ):
    b                   # str object does not support object assignment 

print( b )     
 

string =input();
c=sorted(string)  # it sort the string 
print(c)

b=''.join(c)
print( b )

'''
    
