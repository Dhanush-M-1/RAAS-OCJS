#include <bits/stdc++.h>
using namespace std;
 typedef long long ll;
 
int main() {
int n,m;
cin>>n>>m;
int s[60][60];
int c[60][60];

for(int i=0;i<n;i++)cin>>s[0][i]>>s[1][i];
for(int i=0;i<m;i++)cin>>c[0][i]>>c[1][i];

for(int i=0;i<n;i++){
 int mi=1000000009;
    int k=0;
   for(int j=0;j<m;j++){
       int kari=0;
       kari=abs(s[0][i]-c[0][j])+abs(s[1][i]-c[1][j]);
       if(kari<mi){
           mi=kari;
           k=j+1;
       }
}
cout<<k<<endl;
}
}
