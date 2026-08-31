#include<iostream>

using namespace std;

signed main(){

   while(1){
      int n;
      cin>> n;
      if(!n) break;

      int w[n];
      for(int i=0; i<n; i++){
         string s;
         cin>> s;
         w[i]=s.size();
      }
      int b[]={5, 7, 5, 7, 7};
      for(int i=0; i<n; i++){
         int a=0, p=0;
         for(int j=i; j<n; j++){
            a+=w[j];
            if(a>b[p]){
               goto turai;
            }else if(a==b[p]){
               p++;
               if(p==5) break;
               a=0;
            }
         }
         if(p==5){
            cout<< i+1<< endl;
            break;
         }
         turai:;
      }

   }

   return 0;
}