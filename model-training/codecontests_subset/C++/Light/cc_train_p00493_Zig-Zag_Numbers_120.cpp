#include<bits/stdc++.h>

#define REP(i,s,n) for(int i=s;i<n;i++)
#define rep(i,n) REP(i,0,n)

using namespace std;

const int MOD = 10000;
int dp[2][510][2][3][10]; // dp[桁][%M][値未満か][形状][１つ前] := 総数%MOD
// 形状 0 -> V, 1 -> A, 2 -> malicious end point

int compute(string N,int M){

  rep(j,M)rep(k,2)rep(m,3)rep(l,10) dp[1][j][k][m][l] = 0;
  rep(i,N[0]-'0') dp[1][i%M][1][2][i] = 1;
  dp[1][(N[0]-'0')%M][0][2][N[0]-'0'] = 1;

  int len = N.size();

  REP(i,1,len){ // 桁
    int phase = i & 1;
    rep(j,M)rep(k,2)rep(l,3)rep(m,10) dp[!phase][j][k][l][m] = 0;
    rep(j,10){  // 今みてる値
      rep(k,10){// 次の値
        if( j == 0 ) ( dp[!phase][k%M][1][2][k] += 1 ) %= MOD;

        if( j == k ) continue;

        int state = -1;
        if( j > k ) state = 0;
        else        state = 1;

        rep(l,2){
          bool lt = l | ( N[i]-'0' > k );
          if( !lt && N[i]-'0' < k ) continue;
          rep(m,M) ( dp[!phase][(m*10+k)%M][lt][state&1][k] += ( dp[phase][m][l][(state+1)&1][j] + (j?dp[phase][m][l][2][j]:0) ) ) %= MOD;
        }
      }
    }
  }


  int ret = 0;
  rep(i,2)rep(j,3)rep(k,10) ( ret += dp[len&1][0][i][j][k] ) %= MOD;
  return ret;
}

string minus_one(string s){
  reverse(s.begin(),s.end());
  rep(i,s.size()){
    if( s[i] != '0' ){
      s[i] = (char)((s[i]-'0'-1)+'0');
      reverse(s.begin(),s.end());
      if( s.size() >= 2 && i == (int)s.size()-1 ) s = s.substr(1);
      return s;
    }
    s[i] = '9';
  }
  return "@";
}

int main(){
  string A,B;
  int M;
  while(cin>>A >> B>>M) cout << ( compute(B,M) - compute(minus_one(A),M) + MOD ) % MOD << endl;
  return 0;
}