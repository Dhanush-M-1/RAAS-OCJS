#include<bits/stdc++.h>
using namespace std;
const long long mod=1e9+7;

int main(){
int N,M;
cin>>N>>M;
vector<int>A(N+1,1);
for(int i=0;i<M;++i){
int l;
cin>>l;
A[l]=0;
}

vector<long long int>dp(N+1);
dp[0]=1;
for(int x=0;x<N;x++){
for(int y=x+1;y<=min(N,x+2);y++){
if(A[y]){
dp[y]+=dp[x];
dp[y]%=mod;
}
}
}

cout<<dp[N]<<endl;
}
