#include<iostream>
using namespace std;
int main(){
   char c;
   int k;
   int a[53]={0};
   cin>>a[0];
   for(int i=1;i<=a[0];i++){
      cin>>c>>k;
      if(c=='S')a[k]=1;
      if(c=='H')a[13+k]=1;
      if(c=='C')a[26+k]=1;
      if(c=='D')a[39+k]=1;
   }
   for(int i=1;i<53;i++){
      if(a[i]==0){
         if(i<14)cout<<"S "<<i<<endl;
         if(13<i&&i<27)cout<<"H "<<i-13<<endl;
         if(26<i&&i<40)cout<<"C "<<i-26<<endl;
         if(39<i)cout<<"D "<<i-39<<endl;
      }
   }
   return 0;
}