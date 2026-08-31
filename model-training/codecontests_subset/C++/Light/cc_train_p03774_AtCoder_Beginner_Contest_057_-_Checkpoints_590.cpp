#include<iostream>
#include<string>
#include<algorithm>
#include <stdio.h>
using namespace std;
int main(){
 int n,m; cin >>n >>m;
 long long a[60],b[60],c[60],d[60];

 for(int i=0;i<n;i++)
 cin >>a[i]>>b[i];
 for(int i=0;i<m;i++)
 cin >>c[i]>>d[i];

 for(int i=0;i<n;i++){
   int index;
   long long min=1e09;
   for(int j=0;j<m;j++){
     if(abs(a[i]-c[j])+abs(b[i]-d[j]) < min) {min=abs(a[i]-c[j])+abs(b[i]-d[j]);index= j;}
   }
   cout <<index+1<<endl;
 }

}
