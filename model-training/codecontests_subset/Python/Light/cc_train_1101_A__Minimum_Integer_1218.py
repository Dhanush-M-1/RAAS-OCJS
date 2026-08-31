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

for _ in range(int(input())):
    l, r, d = map(int, input().split())
    print(d if d<l else ((r//d)+1)*d)
