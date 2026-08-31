pas=str(input())
num=int(input())
list1=[]
count1=0
count2=0

if num==1:
    s1=str(input())
    if pas==s1:
        print("YES")
    else:
        s2=s1+s1
        
        if s2[1]==pas[0] and s2[2]==pas[1]:
            print("YES")
        else:
            print("NO")
else:
    for i in range(num):
        s=str(input())
        list1.append(s)
    
    for i in range(len(list1)):
        if list1[i][0]==pas[1]:
            count1+=1
        if list1[i][1]==pas[0]:
            count2+=1
    
    if count1>=1 and count2>=1 :
        print("YES")
    
    elif pas in list1:
        print("YES")
    else:
        print("NO")

		  	 					 	  	   	 	 				 	 	