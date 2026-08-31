#include <cstdio>
#include <cstring>
#include <string>
#include <cmath>
#include <cassert>
#include <iostream>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <set>
#include <map>
#include <bitset>
#include <functional>
#include <numeric>
using namespace std;

#define repl(i,a,b) for(int i=(int)(a);i<(int)(b);i++)
#define rep(i,n) repl(i,0,n)
#define mp(a,b) make_pair((a),(b))
#define pb(a) push_back((a))
#define all(x) (x).begin(),(x).end()
#define dbg(x) cout<<#x"="<<((x))<<endl
#define fi first
#define se second

#define INF 2147483600
#define MOD 10000
#define long long long

long dp[2][2][3][10][500];
// [-][?????????????][????????????????????leading zero?][?????????digit][mod m]

long solve(string &str, int m, bool eq){
  int n=str.size();

  auto prev = dp[0];
  auto crnt = dp[1];
  fill(prev[0][0][0], prev[2][0][0], 0);

  int ini = str[0]-'0';
  repl(i,1, ini+1){
    prev[i==ini][2][i][i%m]=1;
  }

  repl(i,1,n){
    fill(crnt[0][0][0], crnt[2][0][0], 0);
    int lim=str[i]-'0';
    rep(k,10) rep(l,m){
      rep(d,10) if(k!=d) (crnt[0][k<d][d][(l*10+d)%m] += prev[0][k>d][k][l] + prev[0][2][k][l])%=MOD;
      rep(d,lim+1) if(k!=d) (crnt[d==lim][k<d][d][(l*10+d)%m] += prev[1][k>d][k][l] + prev[1][2][k][l])%=MOD;
    }
    repl(d,1,10) crnt[0][2][d][d%m]=1;
    swap(prev, crnt);
  }

  long ret=0;
  rep(i,2) if(i==0 || eq){
    rep(j,3) rep(k,10) (ret += prev[i][j][k][0])%=MOD;
  }
  return ret;
}

int main(){
  string a,b;
  int m;
  cin>>a>>b>>m;
  cout << (solve(b, m, true) - solve(a,m,false) + MOD)%MOD << endl;

  return 0;
}