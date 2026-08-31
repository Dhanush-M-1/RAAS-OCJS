#include <bits/stdc++.h>
 
using namespace std;
 
int main(){
long long int N,M,a;
cin >>N>>M; unsigned long long int S[N+2];
for(long long int i=1;i<N+1;i++){
S[i]=1;
}
S[2]=2;
for(long long int i=0;i<M;i++){
cin >> a;
S[a]=0;
}
if(S[1]==0&&S[2]!=0)S[2]=1;

for(long long int i=1;i<N-1;i++){
if(S[i+2]!=0)S[i+2]=S[i+1]+S[i];
S[i+2]%=1000000007;
}
cout <<S[N];

}
