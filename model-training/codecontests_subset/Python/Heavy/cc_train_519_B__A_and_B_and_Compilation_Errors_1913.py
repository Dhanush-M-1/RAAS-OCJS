"""
Author: Ove Bepari
 
         _nnnn_                      
        dGGGGMMb     ,''''''''''''''''''''''.
       @p~qp~~qMb    | Promoting GNU/Linux  |
       M|@||@) M|   _;......................'
       @,----.JM| -'
      JS^\__/  qKL
     dZP        qKRb
    dZP          qKKb
   fZP            SMMb
   HZM            MMMM
   FqM            MMMM
 __| ".        |\dS"qML
 |    `.       | `' \Zq
_)      \.___.,|     .'
\____   )MMMMMM|   .'
     `-'       `--' hjm
 
"""

n = int(input())
a = sum( [* map(int, input().split())] )
b = sum( [* map(int, input().split())] )
c = sum( [* map(int, input().split())] )
print(a-b, b-c)
