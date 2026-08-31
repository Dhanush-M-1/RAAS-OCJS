#include<bits/stdc++.h>
using namespace std;
int main(){
  int N,M;cin>>N>>M;
  vector<long long>DP(N,-1);
  DP[0]=1;DP[1]=2;
  for(int X=0;X<M;X++){
    int G;cin>>G;DP[G-1]=0;
  }
  if(DP[0]==0&&DP[1]!=0)DP[1]=1;
  for(int X=2;X<N;X++){
    if(DP[X]!=0){
      DP[X]=DP[X-1]+DP[X-2];
      DP[X]%=1000000007;
    }
  }
  cout<<DP[N-1]<<endl;
}