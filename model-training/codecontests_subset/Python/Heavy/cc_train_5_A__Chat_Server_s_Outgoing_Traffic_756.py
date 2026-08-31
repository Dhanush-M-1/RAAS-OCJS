#5A - Chat servers outgoing traffic
#We count the data traffic and the total members in the chat
traffic=0
# people=0
members=0
#While we have input:
while 1:
	try:
        #"Activate" the chat
		chat=input()
        #If we se a '+' at the beginning of the new line, we add the following 
        #person to the members count
		if chat[0]=='+':
			members+=1
        #If we se a '-' at the beginning of the new line, we take out the following 
        #person to the members count
		elif chat[0]=='-':
			members-=1
        #Else, it means the line contains a message, and we add its length to the traffic
		if chat[0]!='+' and chat[0]!='-':
			traffic+=(len(chat[chat.index(':'):])-1)*members
    #When the new line is skipped (enter), we consider the chat ended
	except :
		break
#And we print the result
print(traffic)