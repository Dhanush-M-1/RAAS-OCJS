
#include<bits/stdc++.h>
#define lint long long int
using namespace std;
int main()
{
    int t;
    scanf("%d",&t);

    for(int lops = 0;lops<t;lops++)
    {

       int k,n,m;
       scanf("%d%d%d",&k,&n,&m);
       vector<int> A;
       vector<int> B;
       for(int i = 0;i<n;i++)
       {
           int a;
           scanf("%d",&a);
           A.push_back(a);
       }

       for(int i = 0;i<m;i++)
       {
           int a;
           scanf("%d",&a);
           B.push_back(a);
       }

       vector<int> P;
       int flag = 0;

       int limit = k;
       int i = 0,j = 0;
       while(i<n && j<m)
       {
           if(A[i]<B[j])
           {
               if(A[i]==0) limit++;
               if(A[i]>limit)
               {
                   flag = 1;
                   break;
               }
               P.push_back(A[i]);
               i++;
               continue;
           }

           else
           {
               if(B[j]==0) limit++;
               if(B[j]>limit)
               {
                   flag = 1;
                   break;
               }
               P.push_back(B[j]);
               j++;
               continue;
           }

       }

       while(i<n)
       {
           if(A[i]==0) limit++;
               if(A[i]>limit)
               {
                   flag = 1;
                   break;
               }
               P.push_back(A[i]);
               i++;

       }

       while(j<m)
       {

           if(B[j]==0) limit++;
               if(B[j]>limit)
               {
                   flag = 1;
                   break;
               }
               P.push_back(B[j]);
               j++;


       }

       if(flag) printf("-1\n");
        else
        {
            for(int l = 0;l<m+n;l++)
            {
                printf("%d ",P[l]);

            }
            printf("\n");

        }







    }


    return 0;
}

