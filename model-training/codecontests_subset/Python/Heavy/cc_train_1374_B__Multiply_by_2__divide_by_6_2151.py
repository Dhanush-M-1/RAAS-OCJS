for _ in range(int(input())):
                            
                   t=int(input())
                   ans=0
                   c=0
                   if t==1:print("0")
                   elif t==2or t==4 or t==5:print("-1")
                   elif t==3:print("2")
                   elif t==6:print("1")
                   else:
                        while t>1:
                                  if t%6!=0 and (t*2)%6!=0:
                                            ans=1 
                                            break
                                  else:
                                       if t%6==0:                                
                                            t=t//6 
                                            c+=1
                                       else:
                                            t=t*2
                                            c+=1
                                          
                        if ans==0:print(c)
                        else:print("-1")
                                                        
                                     
                                     
                                     