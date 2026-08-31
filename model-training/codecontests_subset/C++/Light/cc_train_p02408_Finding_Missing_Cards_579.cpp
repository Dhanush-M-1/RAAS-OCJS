#define rep(i, n) for (int i = 0; i < (int)(n); i++)
#define ALL(v) v.begin(), v.end()
typedef long long ll;

#include <bits/stdc++.h>
using namespace std;

int main(){
  int n;
  cin>>n;
  
  int A[4][14];
  rep(i,4){
    rep(j,14) A[i][j]=0;
  }
  
  char c;
  int x;
  rep(i,n){
    cin>>c>>x;
    if(c=='S') A[0][x]=1;
    else if(c=='H') A[1][x]=1;
    else if(c=='C') A[2][x]=1;
    else A[3][x]=1;
  }
  
  string s="SHCD";
  rep(i,4){
    for(int j=1;j<=13;j++){
      if(A[i][j]!=1) cout<<s[i]<<" "<<j<<endl;
    }
  }
  
  return 0;
}
