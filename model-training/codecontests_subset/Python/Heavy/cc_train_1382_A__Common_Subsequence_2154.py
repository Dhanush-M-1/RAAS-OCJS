for _ in range(int(input())):
                             n,m=map(int,input().split())
                             l=[int(x) for x in input().split()]
                             ll=[int(x) for x in input().split()]
                             a=0
                             for i in range(len(l)):
                                                    if l[i] in ll:
                                                                 a=1                        
                                                                 ans=l[i]
                                                                 break
                             if a==0:print("NO")
                             else:
                                  print("YES")
                                  print(1,ans)
                                     
                                     


