#include<bits/stdc++.h>
using namespace std;

int main(){
  long n,m,i,cur,mod=1000000007;
  cin >> n >> m;
  vector<long> ans(n+1);
  for(i=0; i<m; i++){
    cin >> cur;
    ans[cur]=-1;
  }
  ans[0]=1;
  ans[1]+=1;
  for(i=2; i<=n; i++){
    if(ans[i]<0){
      ans[i]=0;
    }else{
      ans[i]=(ans[i-1]+ans[i-2])%mod;
    }
  }
  cout << ans[n];
}
